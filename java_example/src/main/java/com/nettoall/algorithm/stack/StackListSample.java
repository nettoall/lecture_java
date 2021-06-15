package com.nettoall.algorithm.stack;

import java.util.*;

public class StackListSample {
    static LinkedHashMap<Integer, Object> tempList = new LinkedHashMap<>();

//    void init() {
//        tempList.put(1,new Entity("DAT_TYPE",1,0,"R","S"));
//        tempList.put(2,new Entity("DAT_ID",2,0,"F","S"));
//        tempList.put(3,new Entity("DAT_VAL",2,0,"F","S"));
//        tempList.put(4,new Entity("KEY_TYPE",1,0,"F","S"));
//        tempList.put(5,new Entity("GRID1_CNT",1,0,"F","N"));
//        tempList.put(6,new Entity("GRID1",1,5,"G","S"));
//        tempList.put(7,new Entity("COLUMN1",2,0,"C","S"));
//        tempList.put(8,new Entity("COLUMN2",2,0,"C","S"));
//        tempList.put(9,new Entity("COLUMN2",2,0,"C","S"));
//        tempList.put(10,new Entity("FIELD1",1,0,"F","S"));
//        tempList.put(11,new Entity("FIELD2",1,0,"F","S"));
//    }

    void init() {
        tempList.put(1,new Entity("DAT_TYPE",1,0,"R","S"));
        tempList.put(2,new Entity("DAT_ID",2,0,"F","S"));
        tempList.put(3,new Entity("DAT_VAL",2,0,"F","S"));
        tempList.put(4,new Entity("KEY_TYPE",1,0,"F","S"));
        tempList.put(5,new Entity("GRID1_CNT",1,0,"F","N"));
        tempList.put(6,new Entity("GRID1",1,5,"G","S"));
        tempList.put(7,new Entity("COLUMN1-1",2,0,"C","S"));
        tempList.put(8,new Entity("COLUMN1-2",2,0,"C","S"));
        tempList.put(9,new Entity("COLUMN1-3",2,0,"C","S"));
        tempList.put(10,new Entity("GRID2_CNT",2,0,"C","N"));
        tempList.put(11,new Entity("GRID2",2,10,"G","S"));
        tempList.put(12,new Entity("COLUMN2-1",3,0,"C","S"));
        tempList.put(13,new Entity("COLUMN2-2",3,0,"C","S"));
        tempList.put(14,new Entity("COLUMN2-3",3,0,"C","S"));
        tempList.put(15,new Entity("GRID3_CNT",3,0,"C","N"));
        tempList.put(16,new Entity("GRID3",3,15,"G","S"));
        tempList.put(17,new Entity("COLUMN3-1",4,0,"C","S"));
        tempList.put(18,new Entity("COLUMN3-2",4,0,"C","S"));
        tempList.put(19,new Entity("COLUMN3-3",4,0,"C","S"));
        tempList.put(20,new Entity("GRID4_CNT",2,0,"C","N"));
        tempList.put(21,new Entity("GRID4",2,20,"G","S"));
        tempList.put(22,new Entity("COLUMN4-1",3,0,"C","S"));
        tempList.put(23,new Entity("COLUMN4-2",3,0,"C","S"));
        tempList.put(24,new Entity("FIELD1",1,0,"F","S"));
        tempList.put(25,new Entity("FIELD2",1,0,"F","S"));
    }


    public static void main(String[] args) {
        LinkedList<OutputVo> result = new LinkedList<>();
        LinkedList<OutputVo> result2 = new LinkedList<>();
        StackListSample stackListSample = new StackListSample();
        stackListSample.init();
        EntityStack<Entity> stack = new EntityStack<>();

        tempList.forEach((key, value) -> {
            Entity entity = (Entity) value;
            // upnodeid 처리
            if(entity.getFldType().equals("R") || entity.getFldType().equals("G")) {
                if (stack.empty()) {
                    stack.push(entity);
                } else {
                    Entity t1 = (Entity) stack.peek();
                    if (entity.getDepth() == t1.getDepth()) {
                        stack.pop();
                        stack.push(entity);
                    } else if (entity.getDepth() > t1.getDepth()) {
                        stack.push(entity);
                    } else {

                        while (entity.getDepth() < t1.getDepth()) {
                            stack.pop();
                            if (stack.empty())
                                break;
                            t1 = stack.peek();
                        }
                        if(entity.getDepth() == t1.getDepth()){
                            stack.pop();
                        }
                        stack.push(entity);
                    }
                }
            }

            OutputVo vo = new OutputVo();
            vo.setNumber(key);
            vo.setNodeId(entity.getEngNm());
            vo.setDatTp(entity.getDatType());
            vo.setRefSeq(entity.getRefSeq());
            // R타입 처리
            if(entity.getFldType().equals("F") && 2 == entity.getDepth()) {
                Entity root = (Entity) stack.peek();
                vo.setUpNodeId(root.getEngNm());
            }

            if(entity.getFldType().equals("C")) {
                StringBuffer upNode = new StringBuffer();
                for(int i = 0; i <= stack.size() - 1; i++){
                    Entity t2 = (Entity)stack.search(i);
                    if(i == 0){
                        upNode.append(t2.getEngNm());
                    } else {
//                        upNode.append("/" + t2.getEngNm());
                        upNode.insert(0,t2.getEngNm() + "/" );
                    }
                }
                vo.setUpNodeId(upNode.toString());
            }

            if(entity.getFldType().equals("G")) {
                StringBuffer upNode = new StringBuffer();
                for(int i = 0; i < stack.size() - 1; i++){
                    Entity t2 = (Entity)stack.search(i);
                    if(i == 0){
                        upNode.append(t2.getEngNm());
                    } else {
//                        upNode.append("/" + t2.getEngNm());
                        upNode.insert(0,t2.getEngNm() + "/" );
                    }
                }
                vo.setUpNodeId(upNode.toString());
            }
            result.add(vo);
        });

        result2 = stackListSample.validateOutput(result);

        for(OutputVo vo:result2) {
//        for(OutputVo vo:result) {
            System.out.println(vo.toString());
        }
    }

    private LinkedList<OutputVo> validateOutput(LinkedList<OutputVo> list) {
        LinkedList<OutputVo> result = new LinkedList<>();
        for(OutputVo vo  : list) {
            if(vo.getRefSeq() != 0) {

                OutputVo  tmp = list.get(vo.getRefSeq() -1);
                tmp.setUpNodeId(vo.getUpNodeId());
//                vo.setUpNodeId(tmp.getUpNodeId());
                System.out.println("seq : " + vo.getRefSeq() + ",name : " + tmp.getNodeId());
            }
        }
        return list;
    }

}

class Entity {
    String engNm;
    int depth;
    int refSeq;
    String fldType;
    String datType;

    Entity(String engNm, int depth, int refSeq,String fldType, String datType){
        this.engNm = engNm;
        this.depth = depth;
        this.refSeq = refSeq;
        this.fldType = fldType;
        this.datType = datType;
    }

    public String getEngNm(){return this.engNm;}
    public int getDepth(){return this.depth;}
    public int getRefSeq(){ return this.refSeq;}
    public String getFldType(){return this.fldType;}
    public String getDatType(){return this.datType;}

    public String toString() {
        return getEngNm() + ", " + getDepth() + "," + getRefSeq() + ", " +  getFldType() + ", " + getDatType();
    }
}

class OutputVo {
    int number;
    String nodeId;
    String upNodeId;
    String datTp;
    int refSeq;

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNodeId(String nodeId){
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public void setUpNodeId(String upNodeId) {
        this.upNodeId = upNodeId;
    }

    public String getUpNodeId() {
        return this.upNodeId;
    }

    public void setDatTp(String datTp) {
        this.datTp = datTp;
    }

    public String getDatTp() {
        return this.datTp;
    }

    public void setRefSeq(int refSeq) {
        this.refSeq = refSeq;
    }

    public int getRefSeq() {
        return this.refSeq;
    }

    public String toString() {
        return number + ", " + nodeId + ", " + upNodeId + "," + datTp;
    }
}
