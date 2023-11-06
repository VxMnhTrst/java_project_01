package Utils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Utils {
    public static JPanel setPadding(JPanel jPanel, int paddingY, int paddingX, boolean hasBorder)
    {
        JPanel padY = new JPanel();
        padY.setLayout(new BoxLayout(padY,BoxLayout.PAGE_AXIS));

        padY.add(Box.createRigidArea(new Dimension(0,paddingY)));
        padY.add(jPanel);
        padY.add(Box.createRigidArea(new Dimension(0,paddingY)));

        JPanel padX = new JPanel();
        padX.setLayout(new BoxLayout(padX,BoxLayout.LINE_AXIS));

        padX.add(Box.createRigidArea(new Dimension(paddingX,0)));
        padX.add(padY);
        padX.add(Box.createRigidArea(new Dimension(paddingX,0)));

        if(hasBorder)
        {
            padX.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        }
        return padX;
    }
    public static String[][] convertHashMapToTableData(HashMap<String, String[]> rawData)
    {
        String[][] data = new String[rawData.keySet().size()][2];

        int i = 0;
        for(String key : rawData.keySet())
        {
            data[i][0] = key;
            data[i][1] = String.join(" | ",rawData.get(key));
            i++;
        }

        return data;
    }
}
