package com.springcore.springcore;

import java.util.*;

public class CollectionInSpring {
   List addressList;
   Set  addressSet;
   Map  addressMap;
   Properties addressProp;
public List getAddressList() {
	return addressList;
}
public void setAddressList(List addressList) {
	this.addressList = addressList;
}
public Set getAddressSet() {
	return addressSet;
}
public void setAddressSet(Set addressSet) {
	this.addressSet = addressSet;
}
public Map getAddressMap() {
	return addressMap;
}
public void setAddressMap(Map addressMap) {
	this.addressMap = addressMap;
}
public Properties getAddressProp() {
	return addressProp;
}
public void setAddressProp(Properties addressProp) {
	this.addressProp = addressProp;
}
@Override
public String toString() {
	return "CollectionInSpring [addressList=" + addressList + ", addressSet=" + addressSet + ", addressMap="
			+ addressMap + ", addressProp=" + addressProp + "]";
}
   
   }