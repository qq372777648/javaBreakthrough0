package ͼƬˮӡ;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**   
* @author lzw   
* @date 2017��1��9�� ����12:19:35 
* @Description: 
* @version V1.0   
*/
public class ImageMarkLogoByIcon {     
    
    /**   
     * @param args   
     */    
    public static void main(String[] args) {     
        String srcImgPath = "e:/1.jpg";     
        String iconPath = "e:/222.png";     
        String targerPath = "e:/c.jpg" ;   
         // ��ͼƬ���ˮӡ     
        ImageMarkLogoByIcon.markImageByIcon(iconPath, srcImgPath, targerPath , 0);    
    }     
    /**   
     * ��ͼƬ���ˮӡ   
     * @param iconPath ˮӡͼƬ·��   
     * @param srcImgPath ԴͼƬ·��   
     * @param targerPath Ŀ��ͼƬ·��   
     */    
    public static void markImageByIcon(String iconPath, String srcImgPath,     
            String targerPath) {     
        markImageByIcon(iconPath, srcImgPath, targerPath, null) ;   
    }     
    /**   
     * ��ͼƬ���ˮӡ��������ˮӡͼƬ��ת�Ƕ�   
     * @param iconPath ˮӡͼƬ·��   
     * @param srcImgPath ԴͼƬ·��   
     * @param targerPath Ŀ��ͼƬ·��   
     * @param degree ˮӡͼƬ��ת�Ƕ� 
     */    
    public static void markImageByIcon(String iconPath, String srcImgPath,     
            String targerPath, Integer degree) {     
        OutputStream os = null;     
        try {     
            Image srcImg = ImageIO.read(new File(srcImgPath));   
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),     
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);   
            // �õ����ʶ���     
            // Graphics g= buffImg.getGraphics();     
            Graphics2D g = buffImg.createGraphics();     
    
            // ���ö��߶εľ��״��Ե����     
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,     
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);     
    
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg     
                    .getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);     
    
            if (null != degree) {     
                // ����ˮӡ��ת     
                g.rotate(Math.toRadians(degree),     
                        (double) buffImg.getWidth() / 2, (double) buffImg     
                                .getHeight() / 2);     
            }     
            // ˮӡͼ���·�� ˮӡһ��Ϊgif����png�ģ�����������͸����    
            ImageIcon imgIcon = new ImageIcon(iconPath);     
            // �õ�Image����     
            Image img = imgIcon.getImage();     
            float alpha = 0.8f; // ͸����     
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,     
                    alpha));     
            // ��ʾˮӡͼƬ��λ��     
            g.drawImage(img, 0, 0, null);     
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));     
            g.dispose();     
            os = new FileOutputStream(targerPath);     
            // ����ͼƬ     
            ImageIO.write(buffImg, "JPG", os);     
        } catch (Exception e) {     
            e.printStackTrace();     
        } finally {     
            try {     
                if (null != os)     
                    os.close();     
            } catch (Exception e) {     
                e.printStackTrace();     
            }     
        }     
    }     
}   
