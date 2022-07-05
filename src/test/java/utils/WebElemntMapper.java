package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

@UtilityClass
public class WebElemntMapper {

    public Integer webElementWithCurrencyValueToNumber(WebElement value) {
        String stringValue = value.getText().replace("$","").replace(".00","").replace(",","");
        return Integer.valueOf(stringValue);
    }

}
