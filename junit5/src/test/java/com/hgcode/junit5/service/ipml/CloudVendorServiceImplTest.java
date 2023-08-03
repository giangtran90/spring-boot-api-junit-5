package com.hgcode.junit5.service.ipml;

import com.hgcode.junit5.model.CloudVendor;
import com.hgcode.junit5.repository.CloudVendorRepository;
import com.hgcode.junit5.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;

    private CloudVendorService cloudVendorService;
    // de dong tat ca cac tai nguyen khong mong muon khi toan bo lop hoac toan bo qua trinh thuc thi truong hop test ket thuc
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;


    @BeforeEach
    void setUp() {
        // Mo hinh gia se duoc mo o day => vi tu dong dong la dong tat ca cac tai nguyenn ngay khi lop nay ket thuc
        // vi vay se giai phong tat ca ca tai nguye
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1","Amazon","USA","123456");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");
    }

    @Test
    void updateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Success");
    }

    @Test
    void deleteCloudVendor() {
    }

    @Test
    void getCloudVendor() {
    }

    @Test
    void getAllCloudVendors() {
    }

    @Test
    void getByVendorName() {
    }
}