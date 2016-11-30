/**
 * Created by Raymond on 30/11/2016.
 */
$(function() {
    $(document).ajaxSend(function(e,xhr,opt) {
        if (opt.type == "POST"){
            var header = $('meta[name=_csrf_header]').attr('content');
            var token  = $('meta[name=_csrf]').attr('content');
            if (header != '' && token != ''){
                xhr.setRequestHeader(header, token);
            }
        }
    });
});