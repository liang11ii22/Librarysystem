/* ========================================================= 
 * 
 * ��ԭ���ߵĻ����޸�֧�� bootstrap3
 *
 * check-type=
 *   required ����Ϊ�գ����ں����Զ���*��
 *   url  ��ʾ ������ַ
 *   date ���ڸ�ʽ xxxx-xx-xx
 *   mail ����
 *   number ���֣��������ͣ������͡�
 *   char 
 *   chinese ����
 *   mobile  �ֻ�����
 * mail-message="��չ��ʾ����" �� ������չdata-message,url-message  
 * minlength="6" ��ʾ���ȴ��ڵ���6
 * range="2.1~3"   ��ʾֵ��[2.1~3]֮�䣬��check-type="number"
 * range="2.1,2,4,5"   ��ʾֵ��ֻ���������֣���check-type="number" 
 *
 *
 * �ص�Ӧ��:
 * $("form").validation(function(obj,params){
 *     if (obj.id=='mail'){
 *       $.post("/verifymail",{mail :$(obj).val()},function(data){
 *         params.err = !data.success;
 *         params.msg = data.msg;
 *       });
 *     }},
 *     {reqmark:false,icon:true}
 *   );
 *  ���У� reqmark = true ��ʾ��ʾ*��
 *        icon = true ��ʾ��ʾ��ͼ����ʾ�� Ĭ���ǲ���ʾ��
 *
 *
 *  ���   �汾��      ����     �޸�����        �޸�����
 *   1    1.0.0     mrlong    2013-10-2      �����ļ�
 ��   2    1.0.1     mrlong    2013-10-5      callback��ʾ��ʾ����Ϣ��
 *   3.   1.0.2     mrlong    2013-10-7     ���ӻ�������������������ʽ��
 *   4.   1.0.3     mrlong    2013-11-04     �޸�֧��IE8������Array.indexOf() ��Ϊ $.inArray()
 *   5.   1.0.4     mrlong    2014-6-15     �޸���textareaû��typeʱ�Ĵ���,��չvalid����������
 *   6.   1.0.5     mrlong    2015-6-09     �����ֻ���У�鷽ʽ������ surenkid ����
 *   7.   1.0.6     mrlong    2015-6-09     ����ͼ����ʾ����������ʱ�������
 *
 * =========================================================
 * bootstrap-validation.js 
 * Original Idea: http:/www.newkou.org (Copyright 2012 Stefan Petre)
 * Updated by ����ɵ��� (https://github.com/FateSheep/Validation-for-Bootstrap)
 * =========================================================
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================= */
!function($) {
    $.fn.validation = function(callback,options) {
      
        if ( !this.length ) {
            if ( options && options.debug && window.console ) {
                console.warn( "Nothing selected, can't validate, returning nothing." );
            }
            return;
        }
        
        if(typeof callback === 'object'){
          options = callback;
          callback = null;
        };
        
        return this.each(function() {
            globalOptions = $.extend({}, $.fn.validation.defaults, options);  //���ȫ�ֵģ�
            globalOptions.callback = callback;
            // Add novalidate tag if HTML5.
            $(this).attr( "novalidate", "novalidate" );
            fform_style = isformstyle(this);
            validationForm(this)
        });
    };

    $.fn.valid=function(object,options,cb){
        if (formState) { // �ظ��ύ�򷵻�
            return false;
        };
        $("#validerrmsg").remove();

        var myobject;
        var myoptions;
        var mycb;
        if (typeof object === 'object'){
            myobject = $(object);
            if(typeof options === 'string'){
              myoptions = options;
              mycb = cb;
            }
            else{
              mycb = options;  
            }
        }
        else{
          if(typeof object === 'string'){
            myoptions = object;
            mycb = cb;
          }
          else{
            mycb = object;
          };
        };

        formState = true;
        var validationError = false; 
        //ȡ����֤��
        $('input, textarea', this).each(function () {
            var el = $(this), 
                controlGroup = el.parents('.form-group'),
                //check-type="required chinese"  //֧�ֶ�����Կո������
                valid = (el.attr('check-type')==undefined)?null:el.attr('check-type').split(' '); 
            if (!controlGroup.hasClass('has-success') && valid != null && valid.length > 0) {
                if (!validateField(this, valid)) {
                    if (wFocus == false) {
                        scrollTo(0, el[0].offsetTop - 50);
                        wFocus = true;
                    }
                    validationError = true;
                }
            }
        });

        wFocus = false;
        formState = false;
        
        //��ʾ��Ϣ���� 2014-6-15
        //�������ύ��ť������ʾ����
        if(myoptions !=null && validationError){
            if (myobject ==null){
                myobject = $('button:last[type=submit]');
            };
          
            //����ie8��֧��array .indexOf(), �������´��롣
            var classArray = myobject.parent().attr('class').split(' ');  
            var hadgroup = false;
            for(var i=0; i< classArray.length; i++){
              if(classArray[i]=='btn-group'){
                hadgroup = true;
                break;
              }
            };
            if(hadgroup)
            {
              myobject.parent().before('<span id="validerrmsg" class="help-block" style="color: #FF0000;"><div class="alert alert-warning" role="alert" style="padding:10px;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+myoptions+'</div></span>');
            }
            else {
              myobject.before('<span id="validerrmsg" class="help-block" style="color: #FF0000;"><div class="alert alert-warning" role="alert" style="padding:10px;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+myoptions+'</div></span>');
            };
        };
        //end
      
        if(mycb){mycb(validationError);}

        return !validationError;        
    }

   $.fn.validation.defaults = {
        validRules : [
            {name: 'required', validate: function(value) {return ($.trim(value) == '');}, defaultMsg: 'Please full the content'},
            //{name: 'number', validate: function(value) {return (!/^[0-9]\d*$/.test(value));}, defaultMsg: '���������֡�'},
            {name: 'number', validate: function(value) {return (!/^-?(?:\d+|\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(value));}, defaultMsg: 'Please enter the number'},
            //{name: 'mail', validate: function(value) {return (!/^[a-zA-Z0-9]{1}([\._a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+){1,3}$/.test(value));}, defaultMsg: '�����������ַ��'},
            {name: 'mail', validate: function(value) {return (!/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(value));}, defaultMsg: 'Please Enter The Email Address'},
            {name: 'char', validate: function(value) {return (!/^[a-z\_\-A-Z]*$/.test(value));}, defaultMsg: '������Ӣ���ַ���'},
            {name: 'chinese', validate: function(value) {return (!/^[\\S\\s]*[\u4e00-\u9fff]+[\\S\\s]*$/.test(value));}, defaultMsg: '�����뺺�֡�'},
            {name: 'url',validate:function(value){return(!/^(https?|s?ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(value))},defaultMsg:'��������ַ'},
            {name: 'date',validate:function(value){return(/Invalid|NaN/.test(new Date(value).toString()));},defaultMsg:"���ڸ�ʽXXXX-XX-XX��"},
            {name: 'mobile', validate: function(value) {return (!/^0?(13[0-9]|15[0-9]|17[0678]|18[0-9]|14[57])[0-9]{8}$/.test(value));}, defaultMsg: 'Please enter the correct tel number'}
        ],
        reqmark:true,
        callback:null,  //function(obj,params){};
        icon:false      //=icon=true ��ʾ��ʾͼ�꣬Ĭ�ϲ���ʾ
    };

    var formState = false, 
        fieldState = false, 
        wFocus = false, 
        fform_style=0,    //0=��ʾ�������� 1=��ʾ�������� 2=ˮƽ���еı���
        globalOptions = {};

    function isformstyle(form){
        if($(form).hasClass('form-inline')){
            return  1; 
        }
        else if($(form).hasClass('form-horizontal')){
            return  2;
        }
        else{
            return  0;
        };  
    };

    //��֤�ֶ�
    var validateField = function(field, valid) { 
        var el = $(field), error = false, errorMsg = '';
        var minlength=(el.attr('minlength')?el.attr('minlength'):null);
        var range=(el.attr('range')?el.attr('range'):null); //
        var msg;
        for (i = 0; i < valid.length; i++) {
            var x = true, 
                flag = valid[i];
            msg = (el.attr(flag + '-message')==undefined)?null:el.attr(flag + '-message');
                
            if (flag.substr(0, 1) == '!') {
                x = false;
                flag = flag.substr(1, flag.length - 1);
            }

            var rules = globalOptions.validRules;
            for (j = 0; j < rules.length; j++) {
                var rule = rules[j];
                if (flag == rule.name) {
                    var value;
                    if (el.attr('type')!=null && el.attr('type')=='checkbox'){
                        value = el.is(":checked")?'true':'';
                    }
                    else{
                        value=el.val();
                    };
                    if (rule.validate.call(field, value) == x) {
                        error = true;
                        if (el.attr('type')!=null && el.attr('type').toLowerCase()=='file'){
                            errorMsg = (msg == null)?'Please choose a file':msg;
                        }
                        else{
                            errorMsg = (msg == null)?rule.defaultMsg:msg;
                        }
                        break;
                    }
                }
            }
            if (error) {break;}
        }

        //��֤����
        if ( minlength && !error){
            error = el.val().length < minlength;
            if (error && (msg==null || errorMsg=='')){
                errorMsg = 'The characters should more than' + minlength;
            }       
        };

        //ֵ����
        if ($.inArray('number',valid)>=0 && range && !error){
            var values = range.split("~");
            
            if(values.length==2){ 
                error = parseFloat(el.val())<parseFloat(values[0]) || parseFloat(el.val())>parseFloat(values[1]);
                if (error && (msg==null || errorMsg=='')){
                    errorMsg = 'The number should between��' + values[0] + 'and' + values[1] + ']';
                }       
            }
            else{
                var values = range.split(",");
                if (values.length>0){
                    //error =  values.indexOf(el.val())<0;
                    error = $.inArray(el.val(),values)<0;
                    if (error && (msg==null || errorMsg=='')){
                        errorMsg = '����ֵΪ' +range +'������һ����';
                    }
                }
            }
        };

        //�ⲿ��֤�ص�����
        if (!error && globalOptions.callback){
            var params={
                msg:'',
                err:error
            };
            var b = $.ajaxSettings.async;
            $.ajaxSetup({async : false});
            globalOptions.callback(field,params); 
            error = params.err;   
            if (error && (msg==null || errorMsg=='')){
                errorMsg = params.msg;
            }
            else if(params.msg!=''){
                errorMsg = params.msg;
            }
            $.ajaxSetup({async : b});
        };


        var controlGroup = el.parents('.form-group');
        controlGroup.removeClass('has-error has-success');
        
        controlGroup.addClass(error==false?'has-success':'has-error');
        //�ں�������ͼ��
        if(globalOptions.icon===true ){
          controlGroup.find('.form-control-feedback').remove();
          controlGroup.addClass('has-feedback'); //���Ӻ���ͼʾ
        };
      
        var form = el.parents("form");
        if(form){
            var fstyle = isformstyle(form); //0=��ʾ�������� 1=��ʾ�������� 2=ˮƽ���еı���
            var iconname = error==false?'glyphicon-ok':'glyphicon-remove';
            if(fstyle == 0){
                controlGroup.find("#valierr").remove();
                el.after('<span class="help-block" id="valierr">' + errorMsg +'</span>');
                if (globalOptions.icon===true ){
                  if (el.find('option').length==0){
                    el.after('<span class="glyphicon '+ iconname +' form-control-feedback" aria-hidden="true"></span>');
                  }
                  else{
                    el.after('<span class="glyphicon '+ iconname +' form-control-feedback" aria-hidden="true" style="right: 25px;"></span>');  
                  }
                  
                }
            }
            else if(fstyle == 1){
              if (globalOptions.icon===true ){
                if (el.find('option').length==0){
                  el.after('<span class="glyphicon ' + iconname + ' form-control-feedback" aria-hidden="true"></span>');
                }
                else{
                  el.after('<span class="glyphicon '+ iconname +' form-control-feedback" aria-hidden="true" style="right: 25px;"></span>');   
                }
              }
            }
            else if (fstyle == 2){
                controlGroup.find("#valierr").remove();
                el.parent().after('<span class="help-block" id="valierr">' + errorMsg +'</span>');
                if (globalOptions.icon===true ){
                  if (el.find('option').length==0){
                    el.after('<span class="glyphicon '+ iconname +' form-control-feedback" aria-hidden="true"></span>');
                  }
                  else{
                    el.after('<span class="glyphicon '+ iconname +' form-control-feedback" aria-hidden="true" style="right: 25px;"></span>');  
                  }
                }
             }
        };//end !form
        return !error;
    };

    //������֤����
    var validationForm = function(obj) {
           
        //1.��ʧ�����¼�
        $(obj).find('input, textarea,select').each(function(){
            var el = $(this);
            el.on('blur',function(){ // ʧȥ����ʱ
                valid = (el.attr('check-type')==undefined)?null:el.attr('check-type').split(' ');
                if (valid){
                    validateField(this, valid);
                }
            });
        });

        //2.�����ļ�ѡ����Ҫ����onchange�¼�
        $(obj).find("input[type='file']").each(function(){
           var el = $(this);
            el.on('change',function(){ //
                valid = (el.attr('check-type')==undefined)?null:el.attr('check-type').split(' ');
                if (valid){
                    validateField(this, valid);
                }
            }); 
        });

        //3.���ñ���ı�־*��
        if (globalOptions.reqmark==true){
            if(fform_style==0){
                $(obj).find(".form-group>label").each(function(){
                    var el=$(this);
                    var controlGroup = el.parents('.form-group');
                    controlGroup.removeClass('has-error has-success');
                    controlGroup.find("#autoreqmark").remove();
                    el.after('<span id="autoreqmark" style="color:#FF9966"> *</span>')
                });
            }
            else if(fform_style==1){

            }   
            else if(fform_style==2){

                $(obj).find('input, textarea,select').each(function(){
                    var el = $(this);
                    var controlGroup = el.parents('.form-group');
                    controlGroup.removeClass('has-error has-success');
                    controlGroup.find("#valierr").remove();
                    valid = (el.attr('check-type')==undefined)?null:el.attr('check-type').split(' ');
                    if (valid){
                        if ($.inArray('required',valid)>=0){
                            el.parent().after('<span class="help-block" id="valierr" style="color:#FF9966">*</span>');
                        }
                    };
                }); 
            };
        };//end showrequired
      
      //4.���ð�ť type="reset" 2015-6-09
      $(obj).find("input[type='reset'],button[type='reset']").each(function(){
         var el = $(this);
          el.on('click',function(){ //
            $(obj).validation(); 
            $("#validerrmsg").remove();
          }); 
      });
      //end 4

    };
}(window.jQuery);