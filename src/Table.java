import javax.swing.*;


public class Table {
    JFrame f;
    //JPanel contents = new JPanel();

    Table(Object[][] arMass,Object [] strKeys){
        f=new JFrame();
        JTable jt=new JTable(arMass,strKeys);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(500,400);
        f.setVisible(true);

    }
}