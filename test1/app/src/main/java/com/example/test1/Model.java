package com.example.test1;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
	private String carNum;
	private String ownerName;
	private String price;
	private String descr;
	private String phoneNum;
	private String firmName;

	public Model(String carNum, String ownerName, String price, String descr, String phoneNum, String firmName) {
		this.carNum = carNum;
		this.ownerName = ownerName;
		this.price = price;
		this.descr = descr;
		this.phoneNum = phoneNum;
		this.firmName = firmName;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	protected Model(Parcel in) {
		carNum = in.readString();
		ownerName = in.readString();
		price = in.readString();
		descr = in.readString();
		phoneNum = in.readString();
		firmName = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(carNum);
		dest.writeString(ownerName);
		dest.writeString(price);
		dest.writeString(descr);
		dest.writeString(phoneNum);
		dest.writeString(firmName);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Model> CREATOR = new Creator<Model>() {
		@Override
		public Model createFromParcel(Parcel in) {
			return new Model(in);
		}

		@Override
		public Model[] newArray(int size) {
			return new Model[size];
		}
	};
}
