/**
 * Created by Partizanin on 10.12.2014.
 */
// setting defaults for the editable
$.fn.editable.defaults.mode = 'inline';
$.fn.editable.defaults.showbuttons = false;
$.fn.editable.defaults.url = '/post';
$.fn.editable.defaults.type = 'text';

// make all items having class 'edit' editable
$('.edit').editable();

// make username1 editable
$('#username1').editable({
    type: 'text',
    pk: 1,
    url: '/post',
    title: 'Enter username'
});

//ajax emulation
$.mockjax({
    url: '/post',
    responseTime: 200,
    response: function(settings) {
        console.log('done!');
    }
});

// this is to automatically make the next item in the table editable
$('.edit').on('save', function(e, params){
    var that = this;
    // persist the old value in the element to be restored when clicking reset
    var oldItemValue = $(that)[0].innerHTML;
    if (!$(that).attr('oldValue')) {
        console.log('persisting original value: ' + oldItemValue)
        $(that).attr('oldValue', oldItemValue);
    }
    setTimeout(function() {
        // first search the row
        var item = $(that).closest('td').next().find('.edit');
        console.log(item);
        if (item.length == 0) {
            // check the next row
            item = $(that).closest('tr').next().find('.edit');
        }
        item.editable('show');
    }, 200);
});

$('#resetbtn').click(function() {
    $('.edit').each(function() {
        var o = $(this);
        o.editable('setValue', o.attr('oldValue'))	//clear values
            .editable('option', 'pk', o.attr('pk'))	//clear pk
            .removeClass('editable-unsaved')
            .removeAttr('oldValue');
    });
});

$('#savebtn').click(function() {
    $('.edit').editable('submit', {
        url: '/post',
        //ajaxOptions: { dataType: 'json' },
        success: function(data, config) {
            $(this).removeClass('editable-unsaved') //remove unsaved class
                .removeAttr('oldValue');	// clear oldValue
        },
        error: function(errors) {
            console.log('error');
            var msg = '';
            if(errors && errors.responseText) { //ajax error, errors = xhr object
                msg = errors.responseText;
            } else { //validation error (client-side or server-side)
                $.each(errors, function(k, v) { msg += k+": "+v+"<br>"; });
            }
        }
    });
});

