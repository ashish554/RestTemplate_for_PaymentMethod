package com.spring.template.model;

public class PaymentMethod {
		private String methodName;
		private String description;
		private Integer ban;
		private String ifscCode;
		public PaymentMethod(String methodName, String description, Integer ban, String ifscCode) {
			super();
			this.methodName = methodName;
			this.description = description;
			this.ban = ban;
			this.ifscCode = ifscCode;
		}
		public PaymentMethod() {
		}
		public String getMethodName() {
			return methodName;
		}
		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getBan() {
			return ban;
		}
		public void setBan(Integer ban) {
			this.ban = ban;
		}
		public String getIfscCode() {
			return ifscCode;
		}
		public void setIfscCode(String ifscCode) {
			this.ifscCode = ifscCode;
		}

	}


