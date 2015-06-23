package org.benjamin.report.dao;

import org.benjamin.hibernate.Node;
import org.benjamin.report.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
 
 
public class NodeTest {
     
    private static SessionFactory sessionFactory;
     
    @BeforeClass
    public static void beforeClass() {
    	HibernateUtils hu = new HibernateUtils();
    	sessionFactory = hu.getSessionFactory();
    }
     
    @AfterClass
    public static void afterClass() {
        sessionFactory.close();
    }
 
    public void testSave() {
        Session session = sessionFactory.openSession();
        Node node0 = new Node();
        node0.setName("父亲");
        Node node1 = new Node();
        node1.setName("大儿子");
        Node node2 = new Node();
        node2.setName("小儿子");
        Node node3 = new Node();
        node3.setName("大儿子的大儿子");
        Node node4 = new Node();
        node4.setName("大儿子的小儿子");
        Node node5 = new Node();
        node5.setName("小儿子的大儿子");
        Node node6 = new Node();
        node6.setName("小儿子的小儿子");
         
        node0.getChildNodes().add(node1);
        node0.getChildNodes().add(node2);
        node1.getChildNodes().add(node3);
        node1.getChildNodes().add(node4);
        node1.setParentNode(node0);
        node2.getChildNodes().add(node5);
        node2.getChildNodes().add(node6);
        node2.setParentNode(node0);
        node3.setParentNode(node1);
        node4.setParentNode(node1);
        node5.setParentNode(node2);
        node6.setParentNode(node2);
         
        session.beginTransaction();
        session.save(node0);
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void testLoad() {
        testSave();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Node node = (Node)session.load(Node.class, 1);
        print(node,0);
        session.getTransaction().commit();
        session.close();
    }
 
    private void print(Node node,int level) {
        String preStr = "";
        for(int i=0;i<level;i++){
            preStr +="----";
        }
        System.out.println(preStr+node.getName());
        for(Node children:node.getChildNodes()){
            print(children,level+1);
        }   
    }
}
