package com.jakartalabs.page_objects;

public class Dashboard {
	public static final String nameOnDashboardXpath = "//nav[@id='header']/div/div/div[5]/h3/strong";
	
	public static final String typeProjectXpath = "//body/app[@class='eiApp']/div[@id='app-component']/div[@class='wrapper']/div[@class='middlePart']/main/home/div[@class='newHomeSection']/div[@id='home-container']/div[@class='displaySection']/app-product-type/div[@class='productTypeSection']/div[@class='productTypeRow']/drag-scroll/div[@class='drag-scroll-content']/div[1]";
	public static final String typeTemplateXpath = "//body/app[@class='eiApp']/div[@id='app-component']/div[@class='wrapper']/div[@class='middlePart']/main/home/div[@class='newHomeSection']/div[@id='home-container']/div[@class='displaySection']/app-app-list/div[@class='appListSection']/div[@class='appListRow withlock']/div[1]";
	public static final String getStartedXpath = "//div[@id='app-component']/div/div[3]/app-bottom-bar/div/div[3]/div";
	public static final String helloDashboardXpath = "//div[@class='userPanel']//h3";
	
	public static final String skipAfterSelectProjectXpath = "//div[@class='totorialBox step6 active']//span[contains(text(),'SKIP')]";
	
	public static final String maxPriceCss = "div[class='maxpriceBox'] h3 strong";
	
	public static final String planDeliveryButtonXpath = "//button[normalize-space()='Plan Delivery']";
	public static final String doneDeliveryButtonXpath = "//button[normalize-space()='Done']";
	
	public static final String inputTemplateNameXpath = "//input[@placeholder='eg. Booking.com']";
	public static final String saveTemplateNameXpath = "//button[normalize-space()='Save']";
	
	public static final String verifyTemplateNameCss = "div[class='pro-name-strip edit ng-star-inserted'] p[class='strip-head']";
	public static final String verifyPriceXpath = "//p[@class='ng-star-inserted']//strong";
	
	public static final String userPanelCss = "//headerpart[@class='headerPart']//h3[1]";
	public static final String goToDashboardXpath = "//span[normalize-space()='My Dashboard']";
	
	public static final String templateNameCardXpath = "//app-completed-cards//div[@class='cardHead']//h3";
	public static final String burgerMenuCardXpath = "//div[@class='cardMore ng-star-inserted']//em[@class='icon-more']";
	public static final String deleteCardXpath = "//div[@class='cardMore ng-star-inserted']//li[contains(text(),'Delete Card')]";
	public static final String confirmDeleteXpath = "//button[contains(text(),'Yes,')]";
}
