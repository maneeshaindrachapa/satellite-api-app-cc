package com.cloud.satelliteapi.component;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class DemoData implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoData.class);

    @Autowired
    private EntityManager entityManager;

    Query query;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        query = entityManager.createNativeQuery("SELECT COUNT(*) FROM satellite");
        BigInteger result = (BigInteger) query.getSingleResult();
        if (result.intValue() <= 1) {
            query = entityManager.createNativeQuery("INSERT INTO satellite (name, status, health) VALUES ('Nick', 'attached', true), ('Landsat', 'detached', true), " +
                    "('Andromeda-1', 'attached', true), ('Epsilon-1', 'detached', true), ('IRNSS-1H', 'attached', true), ('Galaxy 14', 'detached', true), ('v', 'attached', true), ('NOAA-17', 'detached', true);");
            query.executeUpdate();
        }
    }
}