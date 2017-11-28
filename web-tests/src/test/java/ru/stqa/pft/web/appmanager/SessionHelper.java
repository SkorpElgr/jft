package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String password, String username) {
        type(By.name("pass"), password);
        type(By.name("user"), username);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

    public String getDeviceId() {
        return "devId";
    }

    public String getSessionId() {
        return "sesId";
      //  String rez = "{"+ "access_token"+ ":"+
        //{"access_token":"AAEAAHV6aiOevMD3Hkw_yZPZRe7fcig_MztLc5IRaQK5QzK_n-6Deq1FSd8kqcira3YMVHeVIpVTv6F-mlPi57RhYBmx3zkVUmKpgmAAPX-OulgTFML9Cd3yoC5I474LNqvxfYSKRdckteJM2P0Zpj1JigJbAaamiLn31uQA1zdhh0cbtDRSv-TQFnqwjlWvSiJpr1AxAI751IxSeG_EAXGbJQaRLMFR4gZ8dJv-8yPE60i3KlmSNoNZTV8i0cCSswgEP0prGWm1PJ2BCLHXLR15w1iTF-aAZKWz1YgHz0bIDugBEeRyqysNBmE7g6guvCf4U6wXGJK1giB7JvW9usjxKAj0AgAAAAEAAAFflqR05no9FwrC4A6UuByCGII4spgs2-MIq-yfVFnWsMlWH_sovrNI1t6I8k1GmlqpJLzM9vqJ3dHzfKjjsIG9kmq2BSpUFzBtz_eWXklx1c1iNPZcfv-l4FfQmwbJVVpkAimp0N3aDiThGW9pHs6YwwT36FXcj4Hg2gS3SNWbKLDDeAcoxJY7ZQ0h7kHluOzMtGiDKxpvPkpJ3D_DgM7DYyFD2KYwvTJB-Wed8_52gWzx0cLKQ-q-3G5ZopbifU7DLwo3BBRfdIjh8vYDi_bLMNcNg3JSK7eMwRO9-FolKCARyZ3rYKjWt0SlkQdjfaHGE3fGbiQ8m76wcSDVF5XTd_34F1pR4o2I4A7-hwfaS39y3tQrFZ2wTsVfK1C4pydSnnNHBygGJZoUNqLtGwmcuW4lEjX6vvY8FRvJgECZcvbPyjIvC3Pf5dKU_CblzkMf75mKxZJXqPuDVmP7H22tsQYqy_dPtJu8M36Llf9s0BQYWggz9mR-uwIpvMAiDUkBFXEEHbrNWOabwu7ULpSObRveEnxCmFqZud6HhSxfzBHPLxbStVOzO7qTj_LfnqdgtK0OadXMFxOggM-oAxd-B2d_ytirotnm2UdqRSbuOAy4JYLpkcOt9HShY_st-zVJS9pw3cPceE_cJ0nS2eHogLGKIPkl6-0kUIuo7c-t0O8e5hE4uhHy3PYvv8Pa9THSzHNtuZh4O4NwNUGBA_ZB8odZIZKucI4JrjhXjflDiUKAE13p5CnLQORRj0m6SYzPW4qgTulVLb5-89a4VZfG25c95G0GCBtA6EEOv0errXFFMjhfUPMgQDT-1bTFsNwR2ojeoyHlcz4gqLmJsALTtxIPDXdUdanbtMYrHDqHcfxelkOC1a6fQmhjTwRoUs0DxYqgx_HhMCKA5hzafd0MaR9oC9MN_xGv7abwVzPv5YtIA_95FaxDcDmiFYT3JUFn0a0XY3r3Wfh6eTJqmjxfS5kp8oI6kvGTf6M7LF3t","token_type":"bearer","expires_in":64800,"refresh_token":"UkzO!IAAAABuY05NspJfts_ps--cRaNJUzwHsYLf-pllLaHEooSPE0QAAAAFm8GY6U_skwYGR2XdCDKeUuxdEGdwuejwfZMEkazAPxWj5mxsmybxXopWbx6E7xmbEiZSA_ewscMow2Qj6Hj6u7QL8LXPbWT-HyI-EPCTKIsU2B9dwHy-SGB057z4bXJt1j7SSN1s6lsy_bpymZAyPkI9tS34c4tLW_ezSbRY19esivdFcYhU2hH9V-efXGRq9TRVFTHblSszyBIFbl7vtTYOq2u-1-FtuMWxoD8ohCC_CSHUkaleEPcoc3PTb0Tc8K5dHyx0sjvxWSAqL6TDd","validUntil":1511945348623}
    }

}
