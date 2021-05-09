package basic.io;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileByteWriter {
    public static void main(String[] args){
        File file = new File("testout.file");
        int[] byteLength = new int[]{5, 10, 20, 5, 10, 40};

        int byteFileLength = 0;
        for(int i : byteLength){
            byteFileLength += i;
        }

        byte[] buffer = new byte[byteFileLength];

        List<SampleVo> voList = generateSample(100);
        String lineSeparator = System.getProperty("line.separator");
        try(FileOutputStream fos = new FileOutputStream(file);){
        for(SampleVo vo: voList){
            System.arraycopy(vo.getNum().getBytes(StandardCharsets.UTF_8),0,buffer,0,vo.getNum().getBytes(StandardCharsets.UTF_8).length);
            System.arraycopy(vo.getName().getBytes(StandardCharsets.UTF_8),0,buffer,5,vo.getName().getBytes(StandardCharsets.UTF_8).length);
            System.arraycopy(vo.getJob().getBytes(StandardCharsets.UTF_8),0,buffer,15,vo.getJob().getBytes(StandardCharsets.UTF_8).length);
            System.arraycopy(vo.getSex().getBytes(StandardCharsets.UTF_8),0,buffer,35,vo.getSex().getBytes(StandardCharsets.UTF_8).length);
            System.arraycopy(vo.getPostal().getBytes(StandardCharsets.UTF_8),0,buffer,40,vo.getPostal().getBytes(StandardCharsets.UTF_8).length);
            System.arraycopy(vo.getAddress().getBytes(StandardCharsets.UTF_8),0,buffer,50,vo.getAddress().getBytes(StandardCharsets.UTF_8).length);


                fos.write(buffer);
                fos.write(lineSeparator.getBytes(StandardCharsets.UTF_8));

        }
        } catch(FileNotFoundException fileNotFoundException){

        }catch (IOException ioException){
            ioException.printStackTrace();
        }finally {
//            fos.flush();
        }



    }

    public static List<SampleVo> generateSample(int count){
        List<SampleVo> sampleVoList = new ArrayList<>();
        String sex = "M";
        for(int i = 0; i < count; i++) {
            if(i % 4 == 0)
                sex = "F";

            SampleVo vo = new SampleVo(String.valueOf(i),"홍길도","00001",sex, "123456","서울중구명동1234444");

            sampleVoList.add(vo);
        }
        return sampleVoList;
    }



}

class SampleVo {
    private String num;
    private String name;
    private String job;
    private String sex;
    private String postal;
    private String address;

    public SampleVo(String num, String name, String job, String sex, String postal,String address){
        this.num = num;
        this.name = name;
        this.job = job;
        this.sex = sex;
        this.postal = postal;
        this.address = address;
    }
    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getSex() {
        return sex;
    }

    public String getPostal() {
        return postal;
    }

    public String getAddress() {
        return address;
    }
}
