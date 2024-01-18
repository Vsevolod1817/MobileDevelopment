import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingApp extends JFrame {
    private JPanel drawingPanel;
    private JButton colorButton;
    private JButton clearButton;
    private JPanel panSouth;
    private List<List<Point>> lines = new ArrayList<>();
    private List<Color> lineColors = new ArrayList<>();
    private List<Point> currentLine = new ArrayList<>();
    private Color currentColor = Color.BLACK;

    public DrawingApp() {
        setTitle("Drawing");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int i = 0; i < lines.size(); i++) {
                    List<Point> line = lines.get(i);
                    Color lineColor = lineColors.get(i);

                    g.setColor(lineColor);
                    Point prevPoint = null;
                    for (Point point : line) {
                        if (prevPoint != null) {
                            g.drawLine(prevPoint.x, prevPoint.y, point.x, point.y);
                        }
                        prevPoint = point;
                    }
                }

                if (currentLine != null && currentLine.size() > 1) {
                    g.setColor(currentColor);
                    Point prevPoint = null;
                    for (Point point : currentLine) {
                        if (prevPoint != null) {
                            g.drawLine(prevPoint.x, prevPoint.y, point.x, point.y);
                        }
                        prevPoint = point;
                    }
                }
            }
        };

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    currentLine = new ArrayList<>();
                    currentLine.add(e.getPoint());
                    lineColors.add(currentColor);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (currentLine != null && currentLine.size() > 1) {
                        lines.add(currentLine);
                    }
                    currentLine = null;
                }
            }
        });

        drawingPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentLine != null) {
                    currentLine.add(e.getPoint());
                    drawingPanel.repaint();
                }
            }
        });

        panSouth = new JPanel();


        colorButton= new JButton("Select a color");
        colorButton.setFont(Font.getFont("Times New Roman"));
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(DrawingApp.this, "Select", currentColor);
                if (newColor != null) {
                    currentColor = newColor;
                }
            }
        });

        clearButton = new JButton("Clear");
        clearButton.setFont(Font.getFont("Times New Roman"));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lines.clear(); // Очищаем список линий
                lineColors.clear(); // Очищаем список цветов линий
                drawingPanel.repaint(); // Перерисовываем холст

            }
        });

        panSouth.add(colorButton);
        panSouth.add(clearButton);

        setLayout(new BorderLayout());
        add(drawingPanel, BorderLayout.CENTER);
        add(panSouth, BorderLayout.PAGE_START);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawingApp app = new DrawingApp();
                app.setVisible(true);
            }
        });
    }
}
