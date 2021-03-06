package online.shixun.demo.eshop.eshopserviceproduct.dto;

import java.io.Serializable;
import java.util.Date;

public class EshopSize implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_size.id
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_size.is_del
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    private Integer isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_size.create_time
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_size.update_time
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_size.size_name
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    private String sizeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_size.size_parent_id
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    private String sizeParentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eshop_size.size_type
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    private String sizeType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_size.id
     *
     * @return the value of eshop_size.id
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_size.id
     *
     * @param id the value for eshop_size.id
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_size.is_del
     *
     * @return the value of eshop_size.is_del
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_size.is_del
     *
     * @param isDel the value for eshop_size.is_del
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_size.create_time
     *
     * @return the value of eshop_size.create_time
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_size.create_time
     *
     * @param createTime the value for eshop_size.create_time
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_size.update_time
     *
     * @return the value of eshop_size.update_time
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_size.update_time
     *
     * @param updateTime the value for eshop_size.update_time
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_size.size_name
     *
     * @return the value of eshop_size.size_name
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public String getSizeName() {
        return sizeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_size.size_name
     *
     * @param sizeName the value for eshop_size.size_name
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public void setSizeName(String sizeName) {
        this.sizeName = sizeName == null ? null : sizeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_size.size_parent_id
     *
     * @return the value of eshop_size.size_parent_id
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public String getSizeParentId() {
        return sizeParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_size.size_parent_id
     *
     * @param sizeParentId the value for eshop_size.size_parent_id
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public void setSizeParentId(String sizeParentId) {
        this.sizeParentId = sizeParentId == null ? null : sizeParentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eshop_size.size_type
     *
     * @return the value of eshop_size.size_type
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public String getSizeType() {
        return sizeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eshop_size.size_type
     *
     * @param sizeType the value for eshop_size.size_type
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    public void setSizeType(String sizeType) {
        this.sizeType = sizeType == null ? null : sizeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eshop_size
     *
     * @mbg.generated Fri May 11 10:31:52 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", sizeName=").append(sizeName);
        sb.append(", sizeParentId=").append(sizeParentId);
        sb.append(", sizeType=").append(sizeType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}