package com.restassured.apiassnmnt;

	
	 import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	 import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString), Root.class); */
	public class Item{
	    public String badge_type;
	    public int award_count;
	    public String rank;
	    public int badge_id;
	    public String link;
	    public String name;
		
	    
	    public String getBadge_type() {
			return badge_type;
		}
		public void setBadge_type(String badge_type) {
			this.badge_type = badge_type;
		}
		public int getAward_count() {
			return award_count;
		}
		public void setAward_count(int award_count) {
			this.award_count = award_count;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		public int getBadge_id() {
			return badge_id;
		}
		public void setBadge_id(int badge_id) {
			this.badge_id = badge_id;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	    
	    
	}

	



