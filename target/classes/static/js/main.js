
var myCity;
var myCityCode;
var myDistrict;
var myDong;
var myStr = "";

$(function () {
    $('#searchButton').click(search);
    $('#searchButton2').click(search2);
});

function search() {
    myCity = $("#city option:selected").val();
    myDistrict = $("#district option:selected").val();
    myDong = $("#dong option:selected").val();

    if ((myCity == "") || (myDistrict == "") || (myDong == "")) {
        alert("시, 구, 동을 선택하시오.");
    }
    else {
        $.ajax({
            url: 'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev',
            type: 'GET',
            dataType: 'xml',
            data: {
                'ServiceKey': 'wBmDXLbR+wiK+lSUqvCzBuPli+W+B+RoALqqu6cpoyPSLXuIiF67XX/roGxGB3VFtJAyb3/lS5Dy7zRiEYsGGg==',
                'LAWD_CD': '11110',
                'DEAL_YMD': '201512',
                'numOfRows': '20'
            },
            success: function (xml) {
                $(xml).find('item').each(function () {
                    var item = $(this);
                    var price = item.find('거래금액').text();
                    var year = item.find('건축년도').text();
                    var area = item.find('전용면적').text();
                    var apt = item.find('아파트').text();
                    var dong = item.find('법정동').text().trim();
                    console.log(dong);
                    console.log(myDong);
                    if (myDong == dong) {
                        myStr += `아파트 : ${apt} <br> 법정동 : ${dong} <br> 가격 :  ${price} <br> 전용 면적 :  ${area} <br> 건축 년도 : ${year} <br> <br>`;
                   }
                })
            }
        })
        console.log(myStr);
        setTimeout(function () {
            $('#info').html(myStr);
        }, 2000);
    }
}

function search2() {
    myCity = $("#city option:selected").val();
    myDistrict = $("#district option:selected").val();
    myDong = $("#dong option:selected").val();

    if ((myCity == "") || (myDistrict == "") || (myDong == "")) {
        alert("시, 구, 동을 선택하시오.");
    }
    else {
        $.ajax({
            url: 'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev',
            type: 'GET',
            dataType: 'xml',
            data: {
                'ServiceKey': 'wBmDXLbR+wiK+lSUqvCzBuPli+W+B+RoALqqu6cpoyPSLXuIiF67XX/roGxGB3VFtJAyb3/lS5Dy7zRiEYsGGg==',
                'LAWD_CD': '11110',
                'DEAL_YMD': '201512',
                'numOfRows': '20'
            },
            success: function (xml) {
                $(xml).find('item').each(function () {
                    var item = $(this);
                    var price = item.find('거래금액').text();
                    var year = item.find('건축년도').text();
                    var area = item.find('전용면적').text();
                    var apt = item.find('아파트').text();
                    var dong = item.find('법정동').text().trim();
                    console.log(dong);
                    console.log(myDong);
                    myStr += `아파트 : ${apt} <br> 법정동 : ${dong} <br> 가격 :  ${price} <br> 전용 면적 :  ${area} <br> 건축 년도 : ${year} <br> <br>`;
                })
            }
        })
        setTimeout(function () {
            $('#info').html(myStr);
        }, 2000);
    }
}

