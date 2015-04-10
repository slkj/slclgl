/**
 * 
 */
package cn.slkj.slclgl.vehicle.bean;

/**
 * @author maxh
 *
 */
public class Vehicle {

	private String id;
	
	/********************** 注册登记摘要信息栏 ***********************/
	/**
	 * 车辆归属单位外键
	 */
	private String ownedId;
	/**
	 * 车辆归属单位名称
	 */
	private String ownedName;
	/**
	 * 机动车所有人
	 */
	private String regCompanyName;
	/**
	 * 身份证明名称
	 */
	private String regName;
	/**
	 * 身份证明名号码
	 */
	private String regNum;
	/**
	 * 车辆联系人
	 */
	private String txtContactMenber;
	/**
	 * 联系方式
	 */
	private String txtContactWay;
	/**
	 * 登记机关
	 */
	private String regAuthority;
	/**
	 * 登记日期
	 */
	private String regDate;

	/********************** 注册登记机动车信息栏 ***********************/
	/**
	 * 车牌号(主)
	 */
	private String carMark;
	/**
	 * 车牌号(挂)
	 */
	private String carMarkTrailer;
	/**
	 * 车身颜色
	 */
	private String carColor;
	/**
	 * 车辆类型
	 */
	private String carType;
	/**
	 * 车辆分类
	 */
	private String classify;
	/**
	 * 车辆品牌
	 */
	private String carBrand;
	/**
	 * 车辆型号
	 */
	private String carModel;
	/**
	 * 车辆识别代号/车架号
	 */
	private String carVin;
	/**
	 * 国产/进口
	 */
	private String carProType;
	/**
	 * 发动机号
	 */
	private String carEngNum;
	/**
	 * 发动机型号
	 */
	private String carEngModel;
	/**
	 * 燃料种类
	 */
	private String carFuelType;
	/**
	 * 排量
	 */
	private String carDisplacement;
	/**
	 * 功率
	 */
	private String carPower;
	/**
	 * 制造厂名称
	 */
	private String carManuName;
	/**
	 * 转向形式
	 */
	private String carModality;
	/**
	 * 轮距(前)
	 */
	private String carTreadBe;
	/**
	 * 轮距(后)
	 */
	private String carTreadAfter;
	/**
	 * 轮胎数
	 */
	private String carTireNum;
	/**
	 * 轮胎规格
	 */
	private String carTireSpe;
	/**
	 * 钢板弹簧片数
	 */
	private String carNumOfSpring;
	/**
	 * 轴距
	 */
	private String carAxleDist;
	/**
	 * 轴数
	 */
	private String carAxleNum;
	/**
	 * 外廓尺寸(长)
	 */
	private String carOutLength;
	/**
	 * 外廓尺寸(宽)
	 */
	private String carOutWidth;
	/**
	 * 外廓尺寸(高)
	 */
	private String carOutHeight;
	/**
	 * 货箱内部尺寸(长)
	 */
	private String carContLength;
	/**
	 * 货箱内部尺寸(宽)
	 */
	private String carContWidth;
	/**
	 * 货箱内部尺寸(高)
	 */
	private String carContHeight;
	/**
	 * 总质量
	 */
	private String carTotalmass;
	/**
	 * 核定载质量(吨位/座位)
	 */
	private String carApproved;
	/**
	 * 核定载客
	 */
	private String carApprGuest;
	/**
	 * 准牵引总质量
	 */
	private String carTrac;
	/**
	 * 驾驶室载客
	 */
	private String carCabGuest;
	/**
	 * 使用性质
	 */
	private String carUseNatu;
	/**
	 * 使用性质
	 */
	private String carUseNatuName;
	/**
	 * 车辆获取方式
	 */
	private String carObtWay;
	/**
	 * 车辆出厂日期
	 */
	private String carFacDate;
	/**
	 * 发证时间
	 */
	private String carCertDate;

	/**
	 * 车辆正面彩色照片
	 */
	private String carImg;
	/**
	 * 操作人id

	 */
	private String operatorId;
	/**
	 * 操作人名称
	 */
	private String operatorName;
	/**
	 * 操作时间
	 */
	private String operatorTime;
	
	/**
	 * 录入时间
	 */
	private String entryTime;
	/**
	 * 录入人id

	 */
	private String entryId;
	/**
	 * 录入人名称
	 */
	private String entryName;
	/**
	 * 录入人单位
	 */
	private String depId;
	
}
