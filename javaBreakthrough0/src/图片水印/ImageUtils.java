package ͼƬˮӡ;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
  
 * ͼƬ�����࣬ ͼƬˮӡ������ˮӡ�����ţ����׵�
 * @author Carl He
 */
public final class ImageUtils {
    
    
    /**ͼƬ��ʽ��JPG*/
    private static final String PICTRUE_FORMATE_JPG = "jpg";
    
    private ImageUtils(){}
    /**
     * ���ͼƬˮӡ
     * @param targetImg Ŀ��ͼƬ·�����磺C://myPictrue//1.jpg
     * @param waterImg  ˮӡͼƬ·�����磺C://myPictrue//logo.png
     * @param x ˮӡͼƬ����Ŀ��ͼƬ����ƫ���������x<0, �������м�
     * @param y ˮӡͼƬ����Ŀ��ͼƬ�ϲ��ƫ���������y<0, �������м�
     * @param alpha ͸����(0.0 -- 1.0, 0.0Ϊ��ȫ͸����1.0Ϊ��ȫ��͸��)
*/
    public final static void pressImage(String targetImg, String waterImg, int x, int y, float alpha) {
            try {
                File file = new File(targetImg);
                Image image = ImageIO.read(file);
                int width = image.getWidth(null);
                int height = image.getHeight(null);
                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = bufferedImage.createGraphics();
                g.drawImage(image, 0, 0, width, height, null);
            
                Image waterImage = ImageIO.read(new File(waterImg));    // ˮӡ�ļ�
                int width_1 = waterImage.getWidth(null);
                int height_1 = waterImage.getHeight(null);
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
                
                int widthDiff = width - width_1;
                int heightDiff = height - height_1;
                if(x < 0){
                    x = widthDiff / 2;
                    
                    x = width / 4;
                    width_1=width/2;
                    
                }else if(x > widthDiff){
                    x = widthDiff;
                }
                if(y < 0){
                    y = heightDiff / 2;
                    
                    
                    height_1=(int) (((float)width_1/(float)waterImage.getWidth(null))*(float)height_1);
                    y=(height-height_1)/2;
                    
                }else if(y > heightDiff){
                    y = heightDiff;
                }
                g.drawImage(waterImage, x, y, width_1, height_1, null); // ˮӡ�ļ�����
                g.dispose();
                ImageIO.write(bufferedImage, PICTRUE_FORMATE_JPG, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    /**
     * �������ˮӡ
     * @param targetImg Ŀ��ͼƬ·�����磺C://myPictrue//1.jpg
     * @param pressText ˮӡ���֣� �磺�й�֤ȯ��
     * @param fontName �������ƣ�    �磺����
     * @param fontStyle ������ʽ���磺�����б��(Font.BOLD|Font.ITALIC)
     * @param fontSize �����С����λΪ����
     * @param color ������ɫ
     * @param x ˮӡ���־���Ŀ��ͼƬ����ƫ���������x<0, �������м�
     * @param y ˮӡ���־���Ŀ��ͼƬ�ϲ��ƫ���������y<0, �������м�
     * @param alpha ͸����(0.0 -- 1.0, 0.0Ϊ��ȫ͸����1.0Ϊ��ȫ��͸��)
*/
    public static void pressText(String targetImg, String pressText, String fontName, int fontStyle, int fontSize, Color color, int x, int y, float alpha) {
        try {
            File file = new File(targetImg);
            
            Image image = ImageIO.read(file);
            int width = image.getWidth(null);
            int height = image.getHeight(null);
//            x=width/10*8;
//            y=height/10*9;
            x=-1;
            y=-2;
            
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(image, 0, 0, width, height, null);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setColor(color);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            
            int width_1 = fontSize * getLength(pressText);
            int height_1 = fontSize;
            int widthDiff = width - width_1;
            int heightDiff = height - height_1;
            if(x < 0){
                x = widthDiff / 2;
            }else if(x > widthDiff){
                x = widthDiff;
            }
            if(y < 0){
                y = heightDiff / 2;
            }else if(y > heightDiff){
                y = heightDiff;
            }
            
            
            g.rotate(Math.toRadians(45),(double) width / 2, (double)height / 2);    
            g.drawString(pressText, x, y + height_1);
            g.dispose();
            ImageIO.write(bufferedImage, PICTRUE_FORMATE_JPG, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
http://www.qi788.com/info-43.html
     * ��ȡ�ַ����ȣ�һ��������Ϊ 1 ���ַ�, һ��Ӣ����ĸ��Ϊ 0.5 ���ַ�
     * @param text
     * @return �ַ����ȣ��磺text="�й�",���� 2��text="test",���� 2��text="�й�ABC",���� 4.
*/
    public static int getLength(String text) {
        int textLength = text.length();
        int length = textLength;
        for (int i = 0; i < textLength; i++) {
            if (String.valueOf(text.charAt(i)).getBytes().length > 1) {
                length++;
            }
        }
        return (length % 2 == 0) ? length / 2 : length / 2 + 1;
    }

    /**
     * ͼƬ����
     * @param filePath ͼƬ·��
     * @param height �߶�
     * @param width ���
     * @param bb ��������ʱ�Ƿ���Ҫ����
*/
    public static void resize(String filePath, int height, int width, boolean bb) {
        try {
            double ratio = 0; //���ű���    
            File f = new File(filePath);   
            BufferedImage bi = ImageIO.read(f);   
            Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);   
            //�������   
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {   
                if (bi.getHeight() > bi.getWidth()) {   
                    ratio = (new Integer(height)).doubleValue() / bi.getHeight();   
                } else {   
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();   
                }   
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);   
                itemp = op.filter(bi, null);   
            }   
            if (bb) {   
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
                Graphics2D g = image.createGraphics();   
                g.setColor(Color.white);   
                g.fillRect(0, 0, width, height);   
                if (width == itemp.getWidth(null))   
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);   
                else 
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);   
                g.dispose();   
                itemp = image;   
            }
            ImageIO.write((BufferedImage) itemp, "jpg", f);   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//      pressText("e:/1.jpg", "ˮӡ��������", "����", Font.BOLD, 24, Color.red, 50, 50, 0.7f);
    	pressImage("e:/123.jpg", "e:/vt.png", -1, -1, 1f);
    } 
    
}
