package com.hgcode.junit5.repository;

import com.hgcode.junit5.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


// giup Spring boot hieu no nen su dung co so du lieu nhung trong bo nho
@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1","Amazon","USA","12345678");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // Test case Success
    @Test
    void findByVendorName_Found() {
        List<CloudVendor> cloudVendors = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(cloudVendors.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendors.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }
    // Test case Failure
    @Test
    void findByVendorName_NotFound(){
        List<CloudVendor> cloudVendors = cloudVendorRepository.findByVendorName("Google");
        assertThat(cloudVendors.isEmpty()).isTrue();
    }
}
