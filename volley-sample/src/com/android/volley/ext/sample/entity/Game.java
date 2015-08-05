package com.android.volley.ext.sample.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class Game implements Parcelable {

	
	public Game(String packageName, String versionCode) {
		super();
		this.packageName = packageName;
		this.versionCode = versionCode;
	}

	public Game() {
		super();
	}
	
	public Game(String gid) {
		super();
		this.gid = gid;
	}
	

	public Game(String gid,String packageName, String versionCode,String downloadAddr) {
		super();
		this.gid = gid;
		this.downloadUrl = downloadAddr;
		this.packageName = packageName;
		this.versionCode = versionCode;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5688659958598741277L;
	
	public String id;
	// 图片地址
	public String icon;
	// 游戏描述
	public String desc;
	// 更新时间
	public String updateTime;
	
	public String link;
	// 下载地址
	public String downloadUrl;
	// 下载唯一ID
	public String downloadId;
	// 游戏大小
	public String size;
	// 版本名称
	public String version;
	// 游戏分类名称
	public String category;
	// 游戏分类ID
	public String cateId;
	// 游戏评分
	public float stars;
	public String developer;
	// 游戏名称
	public String name;
	// 游戏ID
	public String gid;
	// 下载次数
	public String downloadTimes;
	// 是否需要升级
	public boolean needUpdate;
	// 包名
	public String packageName;
	// 版本名称
	public String versionName; 
	// 版本号
    public String versionCode;
    // 推荐语
    public String recommend;
    // 安装文件路径
    public String install;
    // 下载状态
    public int downloadStatus;
    // 下载进度百分比
    public int progress;
    // 当前下载多少字节
    public long currentBytes;
	// 立刻下载还是等待wifi下载
    public int flagState;
    // 0,表示下载，1表示更新操作
    public int flag;
    // 游戏标识
    public int tag;
    public int index; // 用户统计
    
    public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int wifistatus;
    
    public View iconView; // 飞入动画效果

	public int getWifistatus() {
		return wifistatus;
	}

	public void setWifistatus(int wifistatus) {
		this.wifistatus = wifistatus;
	}

	public String getInstall() {
		return install;
	}

	public void setInstall(String install) {
		this.install = install;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(String downloadTimes) {
		this.downloadTimes = downloadTimes;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	public Boolean getNeedUpdate() {
		return needUpdate;
	}

	public void setNeedUpdate(Boolean needUpdate) {
		this.needUpdate = needUpdate;
	}
	
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getVersionCode() {
		return versionCode;
	}
	public Game setVersionCode(String versionCode) {
		this.versionCode = versionCode;
		return this;
	}
	
	public String getPackageName() {
		return packageName;
	}
	public Game setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result
				+ ((versionCode == null) ? 0 : versionCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (versionCode == null) {
			if (other.versionCode != null)
				return false;
		} else if (!versionCode.equals(other.versionCode))
			return false;
		return true;
	}
	

	public Game(Parcel source) {
		this.id=source.readString();
		this.packageName = source.readString();
		this.versionName = source.readString();
		this.size = source.readString();	
		this.install = source.readString();
		this.icon = source.readString();
		this.name = source.readString();		
		this.versionCode = source.readString();
		this.downloadUrl = source.readString();
		this.currentBytes = source.readLong();		
		this.downloadStatus = source.readInt();
		this.flagState = source.readInt();
		this.progress=source.readInt();
	}
	
	public int describeContents() {
		return 0;
	}
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.id);
		dest.writeString(this.packageName);
		dest.writeString(this.versionName);
		dest.writeString(this.size);		
		dest.writeString(this.install);
		dest.writeString(this.icon);
		dest.writeString(this.name);
		dest.writeString(this.versionCode);
		dest.writeString(this.downloadUrl);
		dest.writeLong(this.currentBytes);
		dest.writeInt(this.downloadStatus);
		dest.writeInt(this.flagState);
		dest.writeInt(this.progress);
		
	}
	
	public static Parcelable.Creator<Game> getCreator() {
		return CREATOR;
	}
	public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
		public Game createFromParcel(Parcel source) {
			return new Game(source);
		}

		public Game[] newArray(int size) {
			return new Game[size];
		}
	};

	@Override
	public String toString() {
		return "Game [icon=" + icon + ", desc=" + desc + ", updateTime="
				+ updateTime + ", link=" + link + ", downloadUrl="
				+ downloadUrl + ", size=" + size + ", version=" + version
				+ ", category=" + category + ", cateId=" + cateId + ", stars="
				+ stars + ", developer=" + developer + ", name=" + name
				+ ", gid=" + gid + ", downloadTimes=" + downloadTimes
				+ ", needUpdate=" + needUpdate + ", packageName=" + packageName
				+ ", versionName=" + versionName + ", versionCode="
				+ versionCode + ", recommend=" + recommend + "]";
	}
}
