package textprocview;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;
import textproc.GeneralWordCounter;


public class BookReaderController {

    //Constructor with lambda expression to setup the Window
    public BookReaderController(GeneralWordCounter counter){
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height){
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        frame.pack();
        frame.setVisible(true);

    }

}
