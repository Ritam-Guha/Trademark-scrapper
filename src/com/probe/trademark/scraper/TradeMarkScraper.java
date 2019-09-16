package com.probe.trademark.scraper;

import com.probe.selenium.BaseScraper;

import java.io.File;

public class TradeMarkScraper extends BaseScraper {
    @Override
    protected File getConfigFile() {
        return new File("config/trademark.properties");
    }
}