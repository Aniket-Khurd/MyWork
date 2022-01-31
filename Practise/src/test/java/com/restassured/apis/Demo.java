package com.restassured.apis;

import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Demo {

	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString), Root.class); */
	public class Page{
	    public String type;
	}

	public class PerPage{
	    public String type;
	}

	public class Total{
	    public String type;
	}

	public class TotalPages{
	    public String type;
	}

	public class Id{
	    public String type;
	}

	public class Email{
	    public String type;
	}

	public class FirstName{
	    public String type;
	}

	public class LastName{
	    public String type;
	}

	public class Avatar{
	    public String type;
	}

	public class Properties2{
	    public Id id;
	    public Email email;
	    public FirstName first_name;
	    public LastName last_name;
	    public Avatar avatar;
	    public Url url;
	    public Text text;
	    public Page page;
	    public PerPage per_page;
	    public Total total;
	    public TotalPages total_pages;
	    public Data data;
	    public Support support;
	}

	public class Item{
	    public String type;
	    public Properties properties;
	    public List<String> required;
	}

	public class Data{
	    public String type;
	    public List<Item> items;
	}

	public class Url{
	    public String type;
	}

	public class Text{
	    public String type;
	}

	public class Support{
	    public String type;
	    public Properties properties;
	    public List<String> required;
	}

	public class Root{
	    @JsonProperty("$schema") 
	    public String schema;
	    public String type;
	    public Properties properties;
	    public List<String> required;
	}


}
