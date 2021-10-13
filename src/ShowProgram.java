import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.IOException;

public class ShowProgram extends JFrame
{
    { UIManager.put(
            "FileChooser.saveButtonText", "transfer");
        UIManager.put(
                "FileChooser.cancelButtonText", "Cancel");

        UIManager.put(
                "FileChooser.saveInLabelText", "look in");

    }

    private  JButton  btnOpenFile    = null;
    private  JButton  btnConvertFileToTable    = null;


    private  JFileChooser fileChooser = null;

    public ShowProgram() {
        super("Json parser");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnOpenFile = new JButton("open  file");
        btnOpenFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Select directory");
               
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY );
                int result = fileChooser.showOpenDialog(ShowProgram.this);
                
                if (result == JFileChooser.APPROVE_OPTION ) {

                    try {
                        Desktop.getDesktop().edit(fileChooser.getSelectedFile());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnConvertFileToTable = new JButton("transfer file to table");
        btnConvertFileToTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                fileChooser.setDialogTitle("Select directory");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int result = fileChooser.showSaveDialog(ShowProgram.this);
                if (result == JFileChooser.APPROVE_OPTION ) {
                    String fileName= "" +fileChooser.getSelectedFile();
                    new JsonToTable(fileName);
                }
            }
        });

        fileChooser = new JFileChooser();

        JPanel contents = new JPanel();
        contents.add(btnOpenFile   );
        contents.add(btnConvertFileToTable);
        setContentPane(contents);

        setSize(360, 110);
        setVisible(true);

    }

}

