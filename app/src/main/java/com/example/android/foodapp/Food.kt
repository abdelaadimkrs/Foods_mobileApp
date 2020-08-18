package com.example.android.foodapp

class Food{
    var title:String?=null
    var des:String?=null
    var image:Int?=null

    constructor(title: String?, des: String?, image: Int?) {
        this.title = title
        this.des = des
        this.image = image
    }
}