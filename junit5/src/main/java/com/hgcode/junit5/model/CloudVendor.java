package com.hgcode.junit5.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="cloud_vendor_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "This table holds cloud vendor information.")
public class CloudVendor {
    @Id
    @ApiModelProperty(notes="This is a Cloud Vendor Id. It shall be unique.")
    private String vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;
}
