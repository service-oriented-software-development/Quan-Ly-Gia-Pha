$(document).ready(function () {

    $('#lgr h2').click(function () {
        $(this).next().slideToggle();
    });

    StartDvgSuggestion("input#ctl02_right_ctrl0_txtReceiver", "div.msg_sug", 0);
    StartDvgSuggestion("input#ctl02_right_ctrl0_txtReceiverGroup", "div.gmsg_sug", 1);
    $("input#ctl02_right_ctrl0_txtReceiver").trigger("ltsSuggestion");
    $("input#ctl02_right_ctrl0_txtReceiverGroup").trigger("ltsSuggestion");

});

//Suggestion box for composing message
function split(val) {
    return val.split(/,\s*/);
}
function extractLast(term) {
    return split(term).pop();
}
function StartDvgSuggestion(txtInput, contentDiv, opt) 
{
    $(txtInput).bind("ltsSuggestion", function (e) {
        $(txtInput).keyChange(function (evt, text) {
            $(contentDiv).html("");
            $(contentDiv).attr("style", "display: block; background: #fff url(\"../img/utils/loading.gif\") no-repeat scroll center center");
            $(contentDiv).load("ctrls/ucp/mgsearch.aspx?k=" + extractLast(text) + "&opt=" + opt, function () { $(contentDiv).css("background", "#fff") });
        });
        $(txtInput).keypress(function (e) {
            var code = (e.keyCode ? e.keyCode : e.which);
            switch (code) {
                case 38: // up key
                    if ($(contentDiv + " li.cur").length) {
                        $(contentDiv + " li.cur").prev().addClass("cur");
                        $(contentDiv + " li.cur:last").removeClass("cur");
                    }
                    else $(contentDiv + " li:last-child").addClass("cur");
                    break;
                case 40: // down key
                    if ($(contentDiv + " li.cur").length) {
                        $(contentDiv + " li.cur").next().addClass("cur");
                        $(contentDiv + " li.cur:first").removeClass("cur");
                    }
                    else $(contentDiv + " li:first-child").addClass("cur");
                    break;
                case 13: // enter key
                    if ($(contentDiv + " li.cur").length) {
                        var terms = split(this.value);
                        // remove the current input
                        terms.pop();
                        // add the selected item
                        terms.push($(contentDiv + " li.cur").html().replace("&lt;", "<").replace("&gt;", ">"));
                        // add placeholder to get the comma-and-space at the end
                        terms.push("");
                        this.value = terms.join(", ");
                    }
                    break;
            }
        });
        var ss = 0;
        $(contentDiv).mouseover(function () { ss = 1; });
        $(contentDiv).mouseout(function () { ss = 0; });
        $(contentDiv + " li").live("click", function () {
            var terms = split($(txtInput).val());
            // remove the current input
            terms.pop();
            // add the selected item
            terms.push($(this).html().replace("&lt;", "<").replace("&gt;", ">"));
            // add placeholder to get the comma-and-space at the end
            terms.push("");
            $(txtInput).val(terms.join(", "));
            $(contentDiv).hide();
        });
        $(txtInput).focusout(function () {
            if (ss == 0) $(contentDiv).hide();
        });
    });
}

(function ($) {
    $.fn.keyChange = function (options, callback) {

        if ($.isFunction(options)) {
            callback = options;
            options = {};
        }

        options = $.extend({
            minLength: 0,
            delay: 300
        }, options || {});

        return this.each(function () {
            var $input = $(this);
            if (!$input.is('input')) return;
            if ($.isFunction(callback)) {
                $input.bind('keyChange', callback);
            }
            if (!$input.data('keyChangeBindingDone')) {
                var text = String($input.val());
                var search = null;
                $input.keyup(function () {
                    var val = $input.val();
                    if (text != val && val.length >= options.minLength) {
                        text = val;
                        search && clearTimeout(search);
                        search = setTimeout(function () {
                            $input.trigger('keyChange', val);
                        }, options.delay);
                    }
                });
                $input.data('keyChangeBindingDone', true);
            }
        });
    };
})(jQuery);
function getQueryStringValue(paramKey) {
    var queryParameters = {}, queryString = location.search.substring(1),
    re = /([^&=]+)=([^&]*)/g, m;
    while (m = re.exec(queryString)) {
        queryParameters[decodeURIComponent(m[1])] = decodeURIComponent(m[2]);
    }
    return queryParameters[paramKey];
}