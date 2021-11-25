/*第1个图表*/
var nowtime=new Date();
var moth=nowtime.getMonth()+1;
var year=nowtime.getFullYear();
function days(year,month){
    var dayCount;
    now = new Date(year,month, 0);
    dayCount = now.getDate();
    return dayCount;
}
var day=days(moth,year);
var motharr=new Array();
for(var i=0;i<day;i++){
    motharr[i]=i+1;
}
/* var nowdate=new Date();
 nowdate.getMonth();*/
// 基于准备好的dom，初始化echarts实例 上面的div
var tubiao=echarts.init(document.getElementById('main'), 'macarons');

$(function (){
    $.ajax({
        url:'charsnumber',
        type:'post',
        success: function(da){
            // 指定图表的配置项和数据
            var option = {
                title: {
                    x:'center',
                    text: '当日播放流量'//标题
                },
                tooltip: {},
                xAxis: {
                    data: motharr
                },
                yAxis: {

                },
                series: [{
                    type: 'line',
                    data: da.data
                }],
                tooltip: {
                    trigger: 'item',
                    formatter: function(params)
                    {
                        return moth +'月'+params.name+ '日'+' : '+params.data+'人'; //将小数转化为百分数显示
                    }
                },
                grid:{
                    x:50,
                    y:50,
                    x2:0,
                    y2:30
                }
            };
            tubiao.setOption(option);
        }
    })
})



/*第二个图表*/
var tubiao2=echarts.init(document.getElementById('main2'), 'macarons');
$(function(){
    $.ajax({
        url:'charpaynum',
        type:'POST',
        success: function (pay){
            var option2 = {
                title: {
                    x:'center',
                    text: '当日会员收益'//标题
                },
                tooltip: {},
                xAxis: {
                    data: motharr
                },
                yAxis: {

                },
                series: [{
                    type: 'line',
                    data: pay.data
                }],
                tooltip: {
                    trigger: 'item',
                    formatter: function(params)
                    {
                        return moth +'月'+params.name+ '日'+' : '+params.data+'元'; //将小数转化为百分数显示
                    }
                },
                grid:{
                    x:50,
                    y:50,
                    x2:0,
                    y2:30
                }
            };
            tubiao2.setOption(option2);
        }
    })
})


/*返回顶部*/

/*
$(function(){

    // 取窗口滚动条高度
    function getScrollTop(){
        var scrollTop=0;
        if(document.documentElement&&document.documentElement.scrollTop){
            scrollTop=document.documentElement.scrollTop;
        }else if(document.body){
            scrollTop=document.body.scrollTop;
        }
        return scrollTop;
    }
    // 取窗口可视范围的高度
    function getClientHeight(){
        var clientHeight=0;
        if(document.body.clientHeight&&document.documentElement.clientHeight){
            var clientHeight = (document.body.clientHeight<document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;
        }else{
            var clientHeight = (document.body.clientHeight>document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;
        }
        return clientHeight;
    }
    // 取文档内容实际高度
    function getScrollHeight(){
        return Math.max(document.body.scrollHeight,document.documentElement.scrollHeight);
    }

    // 判断是否到达底部
    function scrollAtBottom(){
        if (getScrollTop()+getClientHeight()==getScrollHeight()){
            return true;
        }else{
            return false;
        }
    }

    $(window).scroll(function(){
        if (scrollAtBottom()){
            $(".back-to-ceiling").css("visibility","visible");
        }else{
            $(".back-to-ceiling").css("visibility","hidden");
        }
    })
});
*/

