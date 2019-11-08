package Utils;

import org.junit.Test;
import page_elements.LocatorHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public class RegressionSuit extends Hooks {
    private LocatorHelper helper = new LocatorHelper();

    @Test
    public void searchTest() {

        String searchTerm = "laptop";
        helper.search(searchTerm);
        String actualTitle = helper.getPageTitle();
        String actualThumbNail = helper.getThumbNail();
        String actualCurrentUrl = helper.getCurrentUrl();

        assertThat(actualTitle, is(equalToIgnoringCase(searchTerm)));
        assertThat(actualThumbNail, is(equalToIgnoringCase(searchTerm)));
        assertThat(actualCurrentUrl, containsString(searchTerm));

    }

    @Test
    public void addProductToBasketTest() {
        helper.search("laptop");
        String expected = helper.selectAnyProduct();
        helper.addProductToBasket();
        String actual = helper.getProuctsInBasket();
        assertThat(actual, is(equalToIgnoringCase("")));
    }

    @Test
    public void addProductToBasketUsingFilters() {
        helper.search("laptop");
        helper.selectPrice();
        helper.selectAnyProduct();
        helper.addProductToBasket();
        String actual = helper.getProuctsInBasket();
        assertThat(actual, is(equalToIgnoringCase("")));

    }
}


