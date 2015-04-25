package cn.slkj.slclgl.excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.slkj.slclgl.devices.bean.Devices;
import cn.slkj.slclgl.devices.service.impl.DevicesServiceImpl;

@Controller
@RequestMapping("/upload")
public class DevicesExportExcel {
	@Autowired
	private DevicesServiceImpl impl;

	@ResponseBody
	@RequestMapping("/excel")
	public String upload(HttpServletRequest request, HttpServletResponse response) {

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		/** 构建图片保存的目录 **/
		String pathDir = "/excel/" + dateformat.format(new Date());

		MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;

		MultipartFile file = mulRequest.getFile("myfile");
		String filename = file.getOriginalFilename();
		if (filename == null || "".equals(filename)) {
			return null;
		}
		// 获取保存的路径，
		String realPath = request.getSession().getServletContext().getRealPath(pathDir);
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, filename));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		File file1 = new File(realPath + "/" + filename);
		String[][] result = null;
		try {
			result = getData(file1, 1);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (result == null) {
			return null;
		}
		toDevices(result);
		// int rowLength = result.length;
		// 默认从1 开始 本来是为0 剔除掉
		// for (int i = 0; i < rowLength; i++) {
		// Devices devices = new Devices();
		// for (int j = 0; j < result[i].length; j++) {// 默认从1开始添加
		// switch (j) {
		// case 0:
		// String str = result[i][j].length() > 0 ? result[i][j] : "2";
		// if("已出库".equals(str)){str = "1";}
		// if("未出库".equals(str)){str = "2";}
		// if("退回".equals(str)){str = "3";}
		// if("入网使用".equals(str)){str = "4";}
		// devices.setState(Integer.parseInt(str));
		// break;
		// case 1:devices.setListnum(result[i][j]);break;
		// case 2:devices.setPhone(result[i][j]);break;
		// case 3:devices.setFirm(result[i][j]);break;
		// case 4:devices.setModel(result[i][j]);break;
		// case 5:devices.setRktime(result[i][j]);break;
		// case 6:devices.setLyr(result[i][j]);break;
		// case 7:devices.setLytime(result[i][j]);break;
		// case 8:devices.setFhtime(result[i][j]);break;
		// case 9:devices.setInstallers(result[i][j]);break;
		// case 10:devices.setInstalltime(result[i][j]);break;
		// case 11:devices.setCarNumber(result[i][j]);break;
		// case 12:devices.setCompany(result[i][j]);break;
		// case 13:devices.setNetworkNo(result[i][j]);break;
		// case 14:
		// String test = result[i][j].length() > 0 ? result[i][j] : "0";
		// if("未测试".equals(test)){test = "0";}
		// if("已测试".equals(test)){test = "1";}
		// devices.setTest(Integer.parseInt(test));
		// break;
		// case 15:devices.setCstime(result[i][j]); break;
		// case 16:
		// String tresult = result[i][j].length() > 0 ? result[i][j] :
		// "0";
		// if("不定位".equals(tresult)){tresult = "0";}
		// if("定位".equals(tresult)){tresult = "1";}
		// devices.setTresult(Integer.parseInt(tresult));
		// break;
		// case 17:devices.setArea(result[i][j]); break;
		// }
		// }
		// impl.insert(toDevices(result[i]));
		// }
		return "ok";
	}

	private void toDevices(String[][] result) {
		int rowLength = result.length;
		for (int i = 0; i < rowLength; i++) {
			Devices devices = new Devices();
			for (int j = 0; j < result[i].length; j++) {// 默认从1开始添加
				switch (j) {
				case 0:
					String str = result[i][j];
					if (str.length() <= 0) {
						str = "0";
					} else {
						if ("全新".equals(str)) {
							str = "0";
						}
						if ("返修".equals(str)) {
							str = "1";
						}
						if ("0".equals(str)) {
							str = "0";
						}
						if ("1".equals(str)) {
							str = "1";
						}
					}
					devices.setPack(Integer.parseInt(str));
					break;
				case 1:
					String str1 = result[i][j].length() > 0 ? result[i][j] : "2";
					if ("已出库".equals(str1)) {
						str1 = "1";
					}
					if ("未出库".equals(str1)) {
						str1 = "2";
					}
					if ("退回".equals(str1)) {
						str1 = "3";
					}
					if ("入网使用".equals(str1)) {
						str1 = "4";
					}
					devices.setState(Integer.parseInt(str1));
					break;
				case 2:devices.setListnum(result[i][j]);break;
				case 3:
					devices.setFirm(result[i][j]);
					break;
				case 4:
					devices.setModel(result[i][j]);
					break;
				case 5:
					devices.setRktime(result[i][j]);
					break;
				}
			}
			impl.insert(devices);
		}
	}

	// 将MultipartFile 转换为File
	public static void SaveFileFromInputStream(InputStream stream, String path, String savefile)
			throws IOException {
		FileOutputStream fs = new FileOutputStream(path + "/" + savefile);
		// System.out.println("------------"+path + "/"+ savefile);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}

	public static String[][] getData(File file, int ignoreRows)

	throws FileNotFoundException, IOException {

		List<String[]> result = new ArrayList<String[]>();

		int rowSize = 0;

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(

		file));

		// 打开HSSFWorkbook

		POIFSFileSystem fs = new POIFSFileSystem(in);

		HSSFWorkbook wb = new HSSFWorkbook(fs);

		HSSFCell cell = null;

		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {

			HSSFSheet st = wb.getSheetAt(sheetIndex);

			// 第一行为标题，不取

			for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {

				HSSFRow row = st.getRow(rowIndex);

				if (row == null) {

					continue;

				}

				int tempRowSize = row.getLastCellNum() + 1;

				if (tempRowSize > rowSize) {

					rowSize = tempRowSize;

				}

				String[] values = new String[rowSize];

				Arrays.fill(values, "");

				boolean hasValue = false;

				for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {

					String value = "";

					cell = row.getCell(columnIndex);

					if (cell != null) {

						// 注意：一定要设成这个，否则可能会出现乱码
						// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
						switch (cell.getCellType()) {

						case HSSFCell.CELL_TYPE_STRING:

							value = cell.getStringCellValue();

							break;

						case HSSFCell.CELL_TYPE_NUMERIC:

							if (HSSFDateUtil.isCellDateFormatted(cell)) {

								Date date = cell.getDateCellValue();

								if (date != null) {

									value = new SimpleDateFormat("yyyy-MM-dd")

									.format(date);

								} else {

									value = "";

								}

							} else {

								value = new DecimalFormat("0").format(cell

								.getNumericCellValue());

							}

							break;

						case HSSFCell.CELL_TYPE_FORMULA:

							// 导入时如果为公式生成的数据则无值

							if (!cell.getStringCellValue().equals("")) {

								value = cell.getStringCellValue();

							} else {

								value = cell.getNumericCellValue() + "";

							}

							break;

						case HSSFCell.CELL_TYPE_BLANK:

							break;

						case HSSFCell.CELL_TYPE_ERROR:

							value = "";

							break;

						case HSSFCell.CELL_TYPE_BOOLEAN:

							value = (cell.getBooleanCellValue() == true ? "Y"

							: "N");

							break;

						default:

							value = "";

						}

					}
					if (columnIndex == 0 && value.trim().equals("")) {

						break;

					}

					values[columnIndex] = rightTrim(value);

					hasValue = true;

				}

				if (hasValue) {

					result.add(values);

				}

			}

		}

		in.close();

		String[][] returnArray = new String[result.size()][rowSize];

		for (int i = 0; i < returnArray.length; i++) {

			returnArray[i] = (String[]) result.get(i);

		}

		return returnArray;

	}

	/**
	 * 
	 * 去掉字符串右边的空格
	 * 
	 * @param str
	 *            要处理的字符串
	 * 
	 * @return 处理后的字符串
	 */

	public static String rightTrim(String str) {

		if (str == null) {

			return "";

		}

		int length = str.length();

		for (int i = length - 1; i >= 0; i--) {

			if (str.charAt(i) != 0x20) {

				break;

			}

			length--;

		}

		return str.substring(0, length);

	}
}
