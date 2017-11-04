package com.jyj019.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author jyj019
 *
 */
public final class CommonUtil {

	private CommonUtil() {
		throw new AssertionError();
	}
	
	/**
	 * 根据指定的验证码生成对应的图片
	 * @param code 验证码
	 * @param width 图片的宽度
	 * @param height 图片的高度
	 * @return 验证码图片
	 */
	public static void compressImage(InputStream inputStream, File file, 
			int width, int height) throws IOException {
		BufferedImage oldImage = ImageIO.read(inputStream);
		BufferedImage newImage = new BufferedImage(width, height, 
				BufferedImage.TYPE_INT_RGB);
		newImage.getGraphics().drawImage(oldImage, 0, 0, width, height, null);
		ImageIO.write(newImage, "PNG", file);
	}
	
	/**
	 * 获得全局唯一的文件名
	 */
	public static String getUniqueFilename() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 获取文件名中的后缀名
	 * @param filename 文件名
	 * @return 后缀名
	 */
	public static String getFilenameSuffix(String filename) {
		// assert filename != null;
		int index = filename.lastIndexOf(".");
		return index > 0 && index < filename.length() - 1 ? 
			filename.substring(index) : "";
	}
	
	/**
	 * 锟斤拷时锟斤拷锟斤拷锟节革拷式锟斤拷锟斤拷锟街凤拷锟斤拷
	 * @param pattern 锟斤拷式
	 * @param date 时锟斤拷锟斤拷锟节讹拷锟斤拷
	 * @return 锟斤拷式锟斤拷锟斤拷锟绞憋拷锟斤拷锟斤拷锟斤拷址锟斤拷锟�
	 */
	public static String dateToString(String pattern, Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.format(date);
	}
	
	/**
	 * 锟斤拷锟街凤拷锟斤拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷
	 * @param pattern 锟斤拷式
	 * @param str 时锟斤拷锟斤拷锟斤拷锟街凤拷锟斤拷
	 * @return 时锟斤拷锟斤拷锟节讹拷锟斤拷
	 */
	public static Date stringToDate(String pattern, String str) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			return formatter.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Color getRandColor(int fc,int bc){
	        Random random = new Random();
	        if(fc>255)
	            fc = 255;
	        if(bc>255)
	            bc = 255;
	        int r = fc + random.nextInt(bc - fc);
	        int g = fc + random.nextInt(bc - fc);
	        int b = fc + random.nextInt(bc - fc);
	        return new Color(r,g,b);
	}
	
	public static String generateCode(int len) {
		//OCR光学自动识别
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String rand="";
		for (int i = 0; i < len; i++) {
			char[] code=str.toCharArray();
			Random random = new Random();
			rand =rand+String.valueOf(code[random.nextInt(35)]);
		}
		return rand;		
	}
	

	
	public static BufferedImage generateCodeImage(String code,int width,int height) {
		Random random = new Random();
		  //生成缓冲区image类
		BufferedImage codeImg = new BufferedImage(width, height, 1);
		//产生image类的Graphics用于绘制操作
        Graphics g = codeImg.getGraphics();
        //Graphics类的样式
        g.setColor(CommonUtil.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,37));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(CommonUtil.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }
        //System.out.println("---"+code);
        char[] codes=code.toCharArray();
        //绘制字符
        for(int i=0;i<4;i++){
            String rand =codes[i]+"";
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
		
		return codeImg;
	}
	
}
