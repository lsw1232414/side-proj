package com.lsw.onbid.dto;

public class OnbidItemDto {
    private String cltrNo; // 물건번호
    private String cltrNm; // 물건명
    private String ldnmAdrs; // 지번주소
    private String nmrdAdrs; // 도로명주소
    private String dpslMtdNm; // 처분방식
    private String minBidPrc; // 최저입찰가
    private String apslAsesAvgAmt; // 감정가
    private String bidBegnDtm; // 입찰시작일시
    private String bidClsDtm; // 입찰마감일시
    private String goodsNm; // 상세정보
    private String cltrImgFiles; // 이미지 URL

    // getter / setter
    public String getCltrNo() { return cltrNo; }
    public void setCltrNo(String cltrNo) { this.cltrNo = cltrNo; }
    public String getCltrNm() { return cltrNm; }
    public void setCltrNm(String cltrNm) { this.cltrNm = cltrNm; }
    public String getLdnmAdrs() { return ldnmAdrs; }
    public void setLdnmAdrs(String ldnmAdrs) { this.ldnmAdrs = ldnmAdrs; }
    public String getNmrdAdrs() { return nmrdAdrs; }
    public void setNmrdAdrs(String nmrdAdrs) { this.nmrdAdrs = nmrdAdrs; }
    public String getDpslMtdNm() { return dpslMtdNm; }
    public void setDpslMtdNm(String dpslMtdNm) { this.dpslMtdNm = dpslMtdNm; }
    public String getMinBidPrc() { return minBidPrc; }
    public void setMinBidPrc(String minBidPrc) { this.minBidPrc = minBidPrc; }
    public String getApslAsesAvgAmt() { return apslAsesAvgAmt; }
    public void setApslAsesAvgAmt(String apslAsesAvgAmt) { this.apslAsesAvgAmt = apslAsesAvgAmt; }
    public String getBidBegnDtm() { return bidBegnDtm; }
    public void setBidBegnDtm(String bidBegnDtm) { this.bidBegnDtm = bidBegnDtm; }
    public String getBidClsDtm() { return bidClsDtm; }
    public void setBidClsDtm(String bidClsDtm) { this.bidClsDtm = bidClsDtm; }
    public String getGoodsNm() { return goodsNm; }
    public void setGoodsNm(String goodsNm) { this.goodsNm = goodsNm; }
    public String getCltrImgFiles() { return cltrImgFiles; }
    public void setCltrImgFiles(String cltrImgFiles) { this.cltrImgFiles = cltrImgFiles; }
}
