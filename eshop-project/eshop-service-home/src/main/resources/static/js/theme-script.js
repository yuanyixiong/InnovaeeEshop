(function($) {
    $(window).load(function() {
        // 自适应宽度
        auto_width_megamenu();
        resizeTopmenu();
    });

    $(document).ready(function() {
        /* 调整顶部菜单*/
        resizeTopmenu();
        /* 详情页detail.html 图片放大镜效果 */
        if ($('#product-zoom').length > 0) {
            $('#product-zoom').elevateZoom({
                zoomType: "inner", //类型：内置镜头
                cursor: "crosshair", //光标：十字
                zoomWindowFadeIn: 500, //镜头窗口淡入速度
                zoomWindowFadeOut: 750, //镜头窗口淡出速度
                gallery: 'gallery_01' //分配图像的链接
            });
        }
        /* 详情页detail.html 弹出尺码表*/
        if ($('#size_chart').length > 0) {
            $('#size_chart').fancybox(); //jquery.fancybox.js 弹出框插件
        }
        /** 幻灯片插件owl.carousel.js   产品列表页category.html左侧两处   产品详情页detail.html 畅销产品、销售、你可能喜欢  首页index.html 最新特惠**/
        $(".owl-carousel").each(function(index, el) {

            var config = $(this).data();
            config.navText = ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>']; //添加向左向右的两个图标："<" ">"
            config.smartSpeed = "300";
            if ($(this).hasClass('owl-style2')) { //hasClass() 方法检查被选元素是否包含指定的 class。
                config.animateOut = "fadeOut"; //渐隐
                config.animateIn = "fadeIn"; //渐显
            }
            $(this).owlCarousel(config);
        });
        //首页index.html  运动器材模块中 左侧的小标题上下轮播
        $(".owl-carousel-vertical").each(function(index, el) {
            var config = $(this).data();
            config.navText = ['<span class="icon-up"></span>', '<span class="icon-down"></span>']; //添加向下向上的两个图标
            config.smartSpeed = "900";
            config.animateOut = "";
            config.animateIn = "fadeIn";
            $(this).owlCarousel(config);
        });
        /** 倒计时插件 jquery.countdown.js **/
        $('[data-countdown]').each(function() {
            var $this = $(this),
                finalDate = $(this).data('countdown');
            $this.countdown(finalDate, function(event) {
                var fomat = '<span>%H</span><b></b><span>%M</span><b></b><span>%S</span>';
                $this.html(event.strftime(fomat));
            });
        });
        if ($('.countdown-lastest').length > 0) {
            var labels = ['Years', 'Months', 'Weeks', 'Days', 'Hrs', 'Mins', 'Secs'];
            var layout = '<span class="box-count"><span class="number">{dnn}</span> <span class="text">天</span></span><span class="dot">:</span><span class="box-count"><span class="number">{hnn}</span> <span class="text">时</span></span><span class="dot">:</span><span class="box-count"><span class="number">{mnn}</span> <span class="text">分</span></span><span class="dot">:</span><span class="box-count"><span class="number">{snn}</span> <span class="text">秒</span></span>';
            $('.countdown-lastest').each(function() {
                var austDay = new Date($(this).data('y'), $(this).data('m') - 1, $(this).data('d'), $(this).data('h'), $(this).data('i'), $(this).data('s'));
                $(this).countdown({
                    until: austDay,
                    labels: labels,
                    layout: layout
                });
            });
        }

        /** 搜索框下拉菜单选择类别 **/
        $('.select-category').select2();

        /* 首页每一个分类产品在小分辨率设备下，点击汉堡按钮，产品小标题列表折叠展开*/
        $(document).on('click', '.toggle-menu', function() {
            $(this).closest('.nav-menu').find('.navbar-collapse').toggle();
            return false;
        })


        /* 电梯图标  点击向上的图标，上一组产品自动自动到距离浏览器顶部50px的地方，点击向下的图标，下一组产品自动滚动到距离浏览器顶部50px的地方  */
        $(document).on('click', 'a.btn-elevator', function(e) {
            e.preventDefault(); //取消事件的默认动作。
            var target = this.hash; //hash 属性是一个可读可写的字符串，该字符串是 URL 的锚部分（从 # 号开始的部分）。
            if ($(document).find(target).length <= 0) {
                return false;
            }
            var $target = $(target);
            $('html, body').stop().animate({ //stop() 方法停止当前正在运行的动画。
                'scrollTop': $target.offset().top - 50 //offset() 方法返回或设置匹配元素相对于文档的偏移（位置）
            }, 500);
            return false;
        })

        /* 回到顶部 */
        $(document).on('click', '.scroll_top', function() {
            $('body,html').animate({ scrollTop: 0 }, 400);
            return false;
        })


        // 价格筛选 category.html页面
        $('.slider-range-price').each(function() {
            var min = $(this).data('min');
            var max = $(this).data('max');
            var unit = $(this).data('unit');
            var value_min = $(this).data('value-min');
            var value_max = $(this).data('value-max');
            var label_reasult = $(this).data('label-reasult');
            var t = $(this);
            $(this).slider({
                range: true,
                min: min,
                max: max,
                values: [value_min, value_max],
                slide: function(event, ui) {
                    var result = label_reasult + " " + unit + ui.values[0] + ' - ' + unit + ui.values[1];
                    console.log(t);
                    t.closest('.slider-range').find('.amount-range-price').html(result); //closest() 方法获得匹配选择器的第一个祖先元素，从当前元素开始沿 DOM 树向上
                }
            });
        })


        /** 左侧菜单栏全部分类中隐藏部分，点击所有分类会展开显示**/
        $(document).on('click', '.open-cate', function() {
            $(this).closest('.vertical-menu-content').find('li.cat-link-orther').each(function() {
                $(this).slideDown(); //slideDown() 方法通过使用滑动效果，显示隐藏的被选元素。
            });
            $(this).addClass('colse-cate').removeClass('open-cate').html('关闭'); //removeClass() 方法从被选元素移除一个或多个类。addClass() 方法向被选元素添加一个或多个类。就是把“所有分类”改成“关闭”
        })

        /* 点击关闭，会隐藏部分分类 */
        $(document).on('click', '.colse-cate', function() {
            $(this).closest('.vertical-menu-content').find('li.cat-link-orther').each(function() {
                $(this).slideUp(); //slideUp()通过使用滑动效果，隐藏被选元素，如果元素已显示出来的话。
            });
            $(this).addClass('open-cate').removeClass('colse-cate').html('所有分类');
            return false;
        })

        // 查看分组视图产品 category.html
        $(document).on('click', '.display-product-option .view-as-grid', function() {
            $(this).closest('.display-product-option').find('li').removeClass('selected');
            $(this).addClass('selected');
            $(this).closest('#view-product-list').find('.product-list').removeClass('list').addClass('grid');
            return false;
        })

        // 产品列表视图列表 category.html
        $(document).on('click', '.display-product-option .view-as-list', function() {
            $(this).closest('.display-product-option').find('li').removeClass('selected');
            $(this).addClass('selected');
            $(this).closest('#view-product-list').find('.product-list').removeClass('grid').addClass('list');
            return false;
        })


        /* 首页打开垂直菜单 */
        $(document).on('click', '.btn-open-mobile', function() {
            var width = $(window).width();
            if (width > 1024) {
                if ($('body').hasClass('home')) {
                    if ($('#nav-top-menu').hasClass('nav-ontop')) {} else {
                        return false;
                    }
                }
            }
            $(this).closest('.box-vertical-megamenus').find('.vertical-menu-content').slideToggle(); //slideToggle() 方法通过使用滑动效果（高度变化）来切换元素的可见状态。
            $(this).closest('.title').toggleClass('active'); //toggleClass() 对设置或移除被选元素的一个或多个类进行切换。
            return false;
        })

        /* 关闭垂直菜单 */
        $(document).on('click', '*', function(e) {
            var container = $("#box-vertical-megamenus");
            if (!container.is(e.target) && container.has(e.target).length === 0) { // e.target就是事件源 这里指整个菜单栏
                if ($('body').hasClass('home')) {
                    if ($('#nav-top-menu').hasClass('nav-ontop')) {} else {
                        return;
                    }
                }
                container.find('.vertical-menu-content').hide(); //子菜单栏隐藏
                container.find('.title').removeClass('active');
            }
        })
    });
    /* ---------------------------------------------
     脚本调整
     --------------------------------------------- */
    $(window).resize(function() {
        auto_width_megamenu();
        // remove_menu_ontop();
        resizeTopmenu();
    });

    $(window).scroll(function() {
        /* 显示或隐藏回到顶部的按钮 */
        if ($(window).scrollTop() == 0) { //scrollTop() 方法返回或设置匹配元素的滚动条的垂直位置。
            $('.scroll_top').stop(false, true).fadeOut(600);
        } else {
            $('.scroll_top').stop(false, true).fadeIn(600);
        }

        /* 悬浮菜单栏的样式 */
        var h = $(window).scrollTop(); //滚动条到顶部的垂直距离
        var max_h = $('#header').height();
        var width = $(window).width();
        if (width > 767) { //大分辨率设备下
            if (h > (max_h + vertical_menu_height) - 50) { //如果滚动条到顶部的距离大于头部加菜单栏的高度-50px    导航栏的高度是50px
                $('#nav-top-menu').addClass('nav-ontop');
                $('#cart-block .cart-block').appendTo('#shopping-cart-box-ontop .shopping-cart-box-ontop-content'); //appendTo() 方法在被选元素的结尾（仍然在内部）插入指定内容。  这里指插入购物车图标
                $('#shopping-cart-box-ontop').fadeIn(); //fadeIn() 方法使用淡入效果来显示被选元素，假如该元素是隐藏的。实际效果：购物车图标是淡入显示
                $('#user-info-top').appendTo('#user-info-opntop'); //添加个人中心图标
                $('#header .header-search-box form').appendTo('#form-search-opntop'); //添加搜索图标
            } else { //小分辨率设备下
                $('#nav-top-menu').removeClass('nav-ontop');
                if ($('body').hasClass('home')) {
                    $('#nav-top-menu').find('.vertical-menu-content').removeAttr('style'); //removeAttr() 方法从被选元素中移除属性。
                    if (width > 1024)
                        $('#nav-top-menu').find('.vertical-menu-content').show(); //垂直子菜单显示
                    else {
                        $('#nav-top-menu').find('.vertical-menu-content').hide(); //垂直子菜单隐藏
                    }
                    $('#nav-top-menu').find('.vertical-menu-content').removeAttr('style');
                }
                $('#shopping-cart-box-ontop .cart-block').appendTo('#cart-block'); //购物车下拉框显示
                $('#shopping-cart-box-ontop').fadeOut(); //fadeOut() 方法使用淡出效果来隐藏被选元素，假如该元素是显示的。
                $('#user-info-opntop #user-info-top').appendTo('.top-header .container'); //个人中心下拉框显示
                $('#form-search-opntop form').appendTo('#header .header-search-box'); //搜索框显示
            }
        }
    });
    var vertical_menu_height = $('#box-vertical-megamenus .box-vertical-megamenus').innerHeight(); //innerHeight()为匹配的元素集合中获取第一个元素的当前计算高度值,包括padding，但是不包括border。 这里指左侧菜单栏的高度

    //菜单栏下拉框的宽度   使用到jquery.actual.min.js插件
    function auto_width_megamenu() {
        var full_width = parseInt($('.container').innerWidth());
        var menu_width = parseInt($('.vertical-menu-content').actual('width'));
        $('.vertical-menu-content').find('.vertical-dropdown-menu').each(function() {
            $(this).width((full_width - menu_width) - 2);
        });
    }

    /* 滚动条宽度*/
    function scrollCompensate() { //滚动
        var inner = document.createElement('p');
        inner.style.width = "100%";
        inner.style.height = "200px";
        var outer = document.createElement('div');
        outer.style.position = "absolute";
        outer.style.top = "0px";
        outer.style.left = "0px";
        outer.style.visibility = "hidden";
        outer.style.width = "200px";
        outer.style.height = "150px";
        outer.style.overflow = "hidden";
        outer.appendChild(inner); //appendChild() 方法向节点添加最后一个子节点。
        document.body.appendChild(outer);
        var w1 = parseInt(inner.offsetWidth); //offsetWidth 是对象的可见宽度，包滚动条等边线，会随窗口的显示大小改变
        outer.style.overflow = 'scroll';
        var w2 = parseInt(inner.offsetWidth);
        if (w1 == w2) w2 = outer.clientWidth; //可见区域宽度
        document.body.removeChild(outer);
        return (w1 - w2);
    }
    //设置导航栏下拉框的宽度和位置
    function resizeTopmenu() {
        if ($(window).width() + scrollCompensate() >= 768) {
            var main_menu_w = $('#main-menu .navbar').innerWidth(); //innerWidth()返回元素的宽度（包含 padding）  这里指导航栏
            $("#main-menu ul.mega_dropdown").each(function() { //导航栏的下拉菜单
                var menu_width = $(this).innerWidth(); //下拉菜单的宽度
                var offset_left = $(this).position().left; //position() 方法返回匹配元素相对于父元素的位置（偏移）。 这里指下拉菜单的左边距离

                if (menu_width > main_menu_w) { //如果下拉菜单的宽度大于导航栏的宽度
                    $(this).css('width', main_menu_w + 'px'); //把导航栏的宽度赋值给下拉菜单的宽度
                    $(this).css('left', '0'); //左边距为0px
                } else {
                    if ((menu_width + offset_left) > main_menu_w) { //如果下拉菜单的宽度+左边距的宽度大于导航栏的宽度
                        var t = main_menu_w - menu_width; //t=导航栏的宽度-下拉菜单的宽度
                        var left = parseInt((t / 2)); //设置下拉菜单的左边距
                        $(this).css('left', left);
                    }
                }
            });
        }

    }
})(jQuery);
