(function(){var r=false;var o=/xyz/.test(function(){xyz})?/\b_super\b/:/.*/;var s=function(){};s.extend=function(t){var i=this.prototype;r=true;var n=new this;r=false;for(var a in t){n[a]=typeof t[a]=="function"&&typeof i[a]=="function"&&o.test(t[a])?function(a,e){return function(){var t=this._super;this._super=i[a];var n=e.apply(this,arguments);this._super=t;return n}}(a,t[a]):t[a]}function e(){if(!r&&this.init)this.init.apply(this,arguments)}e.prototype=n;e.prototype.constructor=e;e.extend=arguments.callee;return e};window.Class=function(t,n){var a=t.split(".");var e=window;for(var i=0;i<a.length;i++){if(typeof e[a[i]]=="undefined"){e[a[i]]={}}if(i==a.length-1){e[a[i]]=s.extend(n)}else{e=e[a[i]]}}}})();$.request=function(e){e=e?e:{};var t=e&&e.url?e.url:"";var n=e&&e.method?e.method:"GET";var a=e.error?e.error:"操作失败!";var i=e.fail?e.fail:"请求失败!";var r={};var o=e&&e.fail?e.fail:"";r.url=t;r.type=n;r.dataType=e.dataType?e.dataType:"json";r.contentType=e.contentType?e.contentType:"application/json; charset=utf-8";r.cache=false;r.that=e.that;r.async=e.async?e.async:true;r.data=e.data;if(e.param){r.data=JSON.stringify(e.param)}$.ajax(r).done(function(t){if(e.success instanceof Function){if(isUserNotLogin(t)){goToLogin()}e.resp=t;e.success(e)}}).fail(function(t){if(o instanceof Function){e.fail(t)}else{}}).always(function(t,n,a){if(e.always instanceof Function){e.always(t)}})};