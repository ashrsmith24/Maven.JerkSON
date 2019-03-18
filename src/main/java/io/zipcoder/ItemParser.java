package io.zipcoder;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.List;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        parseSingleItem().
    }

    // naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##
    public Item parseSingleItem(String singleItem) throws ItemParseException {
        Item result = null;
        String name = null;
        Double price = null;
        String type = null;
        String expiration = null;

        // set input to lowercase
        singleItem = singleItem.toLowerCase();
        // remove pound sign
        singleItem = singleItem.replaceAll("##","");


        // split on semicolon to create an fieldPairStringArray
        String[] fieldPairStringArray = singleItem.split(";");

        // ["naMe:Milk",   "price:3.23",  "type:Food",   "expiration:1/25/2016##"]

        // For every fieldPair in fieldPairStringArray
        for (int i = 0; i < fieldPairStringArray.length; i++) {
            String fieldPair = fieldPairStringArray[i];


            // split at colon to get keyAndValue
            String[] keyAndValue = fieldPair.split("[:^@*%]");

            // get key from keyAndValue
            String key = keyAndValue[0];
            // get value from keyAndValue
            String value = keyAndValue[1];


            // check if key is name, price, type, or expiration
                // if key is name, set name equal to value
            if(key.equalsIgnoreCase("name")){
                    name = value;
            }
            // if key is price, set price equal to value
            if(key.equalsIgnoreCase("price")){
                    price = Double.parseDouble(value);
            }
                // if key is type, set type equal to value
            if(key.equalsIgnoreCase("type")){
                    type = value;
            }
                // if key is expiration, set expiration equal to value
            if(key.equalsIgnoreCase("expiration")){
                    expiration = value;
            }
        }
        // instantiate object with name, price, type, and expiration
                    result = new Item(name,price,type,expiration);
        return result;
    }
}
