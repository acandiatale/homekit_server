(function(n){function t(t){for(var r,c,f=t[0],i=t[1],l=t[2],p=0,s=[];p<f.length;p++)c=f[p],Object.prototype.hasOwnProperty.call(o,c)&&o[c]&&s.push(o[c][0]),o[c]=0;for(r in i)Object.prototype.hasOwnProperty.call(i,r)&&(n[r]=i[r]);a&&a(t);while(s.length)s.shift()();return u.push.apply(u,l||[]),e()}function e(){for(var n,t=0;t<u.length;t++){for(var e=u[t],r=!0,f=1;f<e.length;f++){var i=e[f];0!==o[i]&&(r=!1)}r&&(u.splice(t--,1),n=c(c.s=e[0]))}return n}var r={},o={app:0},u=[];function c(t){if(r[t])return r[t].exports;var e=r[t]={i:t,l:!1,exports:{}};return n[t].call(e.exports,e,e.exports,c),e.l=!0,e.exports}c.m=n,c.c=r,c.d=function(n,t,e){c.o(n,t)||Object.defineProperty(n,t,{enumerable:!0,get:e})},c.r=function(n){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(n,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(n,"__esModule",{value:!0})},c.t=function(n,t){if(1&t&&(n=c(n)),8&t)return n;if(4&t&&"object"===typeof n&&n&&n.__esModule)return n;var e=Object.create(null);if(c.r(e),Object.defineProperty(e,"default",{enumerable:!0,value:n}),2&t&&"string"!=typeof n)for(var r in n)c.d(e,r,function(t){return n[t]}.bind(null,r));return e},c.n=function(n){var t=n&&n.__esModule?function(){return n["default"]}:function(){return n};return c.d(t,"a",t),t},c.o=function(n,t){return Object.prototype.hasOwnProperty.call(n,t)},c.p="/";var f=window["webpackJsonp"]=window["webpackJsonp"]||[],i=f.push.bind(f);f.push=t,f=f.slice();for(var l=0;l<f.length;l++)t(f[l]);var a=i;u.push([0,"chunk-vendors"]),e()})({0:function(n,t,e){n.exports=e("56d7")},"034f":function(n,t,e){"use strict";e("85ec")},"56d7":function(n,t,e){"use strict";e.r(t);e("e260"),e("e6cf"),e("cca6"),e("a79d");var r=e("2b0e"),o=function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",{attrs:{id:"app"}},[e("b-button",{attrs:{type:"is-success"},on:{click:n.turn_on}},[n._v("TURN ON")]),e("b-button",{attrs:{type:"is-danger"},on:{click:n.turn_off}},[n._v("TURN OFF")])],1)},u=[],c=(e("d3b7"),{name:"App",methods:{turn_on:function(){fetch("http://127.0.0.1:12732/turn_on").then((function(n){return n.json()})).then((function(n){return console.log(n)})).catch((function(n){return console.log(n)}))},turn_off:function(){fetch("http://127.0.0.1:12732/turn_off").then((function(n){return n.json()})).then((function(n){return console.log(n)}))}}}),f=c,i=(e("034f"),e("2877")),l=Object(i["a"])(f,o,u,!1,null,null,null),a=l.exports,p=e("289d");e("5abe");r["a"].use(p["a"]),new r["a"]({render:function(n){return n(a)}}).$mount("#app")},"85ec":function(n,t,e){}});
//# sourceMappingURL=app.97bc9cb2.js.map