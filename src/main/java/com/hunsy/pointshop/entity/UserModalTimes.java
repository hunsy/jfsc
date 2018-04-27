package com.hunsy.pointshop.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_modal_times")
public class UserModalTimes {
    @Id
    private Long id;

    /**
     * app_id
     */
    @Column(name = "app_id")
    private Long appId;

    /**
     * �û��˺�
     */
    @Column(name = "user_account")
    private String userAccount;

    /**
     * �¼���
     */
    @Column(name = "serial_id")
    private Long serialId;

    /**
     * �¼�����
     */
    @Column(name = "modal_type")
    private Integer modalType;

    /**
     * �¼���������
     */
    private Integer times;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * ɾ����ʶ  1 ���� 0 ɾ��
     */
    private Byte valid;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * ��ȡapp_id
     *
     * @return app_id - app_id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * ����app_id
     *
     * @param appId app_id
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * ��ȡ�û��˺�
     *
     * @return user_account - �û��˺�
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * �����û��˺�
     *
     * @param userAccount �û��˺�
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * ��ȡ�¼���
     *
     * @return serial_id - �¼���
     */
    public Long getSerialId() {
        return serialId;
    }

    /**
     * �����¼���
     *
     * @param serialId �¼���
     */
    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    /**
     * ��ȡ�¼�����
     *
     * @return modal_type - �¼�����
     */
    public Integer getModalType() {
        return modalType;
    }

    /**
     * �����¼�����
     *
     * @param modalType �¼�����
     */
    public void setModalType(Integer modalType) {
        this.modalType = modalType;
    }

    /**
     * ��ȡ�¼���������
     *
     * @return times - �¼���������
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * �����¼���������
     *
     * @param times �¼���������
     */
    public void setTimes(Integer times) {
        this.times = times;
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * ��ȡɾ����ʶ  1 ���� 0 ɾ��
     *
     * @return valid - ɾ����ʶ  1 ���� 0 ɾ��
     */
    public Byte getValid() {
        return valid;
    }

    /**
     * ����ɾ����ʶ  1 ���� 0 ɾ��
     *
     * @param valid ɾ����ʶ  1 ���� 0 ɾ��
     */
    public void setValid(Byte valid) {
        this.valid = valid;
    }
}