import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

/**
 * Main ToolWindow
 */
public class MainToolWindowFactory implements ToolWindowFactory {
    private ToolWindow toolWindow;
    private JPanel mainPanel;
    private JToolBar mainToolbar;
    private JButton btnAdd;
    private JButton btnClose;
    private JButton btnHelp;
    private JTabbedPane tabbedPane;
    private JPanel defaultPane;

    public MainToolWindowFactory() {
        btnHelp.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("http://wuruihong.com"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        this.toolWindow = toolWindow;

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(mainPanel, "", false);
        this.toolWindow.getContentManager().addContent(content);
    }

    protected void createUIComponents() {

    }
}
