package com.example.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTableService {
    private final Logger logger = LoggerFactory.getLogger(TestTableService.class);
    private final TestTableRepository testTableRepository;

    @Autowired
    public TestTableService(TestTableRepository testTableRepository) {

        this.testTableRepository = testTableRepository;
    }

    public List<TestTable> getTable(String name) {
        logger.info("getTable called with name: " + name);
        return testTableRepository.findAllByName(name);
    }
}