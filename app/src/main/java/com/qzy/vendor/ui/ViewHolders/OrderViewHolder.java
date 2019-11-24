package com.qzy.vendor.ui.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;

public class OrderViewHolder extends RecyclerView.ViewHolder{
    private TextView statusText,orderNo,orderContents,orderTotal;
    private ImageView arrowIcon;

    public RelativeLayout getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(RelativeLayout orderStatus) {
        this.orderStatus = orderStatus;
    }

    private RelativeLayout orderDetails,acceptLayout,declineLayout,orderStatus;
    private RecyclerView orderLineItems;

    public TextView getStatusText() {
        return statusText;
    }

    public void setStatusText(TextView statusText) {
        this.statusText = statusText;
    }

    public TextView getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(TextView orderNo) {
        this.orderNo = orderNo;
    }

    public TextView getOrderContents() {
        return orderContents;
    }

    public void setOrderContents(TextView orderContents) {
        this.orderContents = orderContents;
    }

    public TextView getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(TextView orderTotal) {
        this.orderTotal = orderTotal;
    }

    public ImageView getArrowIcon() {
        return arrowIcon;
    }

    public void setArrowIcon(ImageView arrowIcon) {
        this.arrowIcon = arrowIcon;
    }

    public RelativeLayout getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(RelativeLayout orderDetails) {
        this.orderDetails = orderDetails;
    }

    public RelativeLayout getAcceptLayout() {
        return acceptLayout;
    }

    public void setAcceptLayout(RelativeLayout acceptLayout) {
        this.acceptLayout = acceptLayout;
    }

    public RelativeLayout getDeclineLayout() {
        return declineLayout;
    }

    public void setDeclineLayout(RelativeLayout declineLayout) {
        this.declineLayout = declineLayout;
    }

    public RecyclerView getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(RecyclerView orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        statusText = itemView.findViewById(R.id.status_text);
        orderNo = itemView.findViewById(R.id.order_no);
        orderContents = itemView.findViewById(R.id.order_contents_short);
        orderTotal = itemView.findViewById(R.id.order_total);
        arrowIcon = itemView.findViewById(R.id.arrow_icon);
        orderDetails = itemView.findViewById(R.id.order_details_expand);
        acceptLayout = itemView.findViewById(R.id.accept_layout);
        declineLayout = itemView.findViewById(R.id.decline_layout);
        orderLineItems = itemView.findViewById(R.id.order_lineitem);
        orderStatus = itemView.findViewById(R.id.order_status);
    }
}