var Crawler = require("crawler");
var url = 'http://misfitathletics.com/mft-348';

var c = new Crawler({
    "maxConnections":10,

    // This will be called for each crawled page
    "callback":function(error,result,$) {
    
        // $ is a jQuery instance scoped to the server-side DOM of the page
        //$("#content a").each(function(index,a) {
        //    c.queue(a.href);
        //});
        
        //console.log(result.body)
        
        if(result){
            var page = result.body;
            console.log(page);
            var res = page.match(/helton/g);
            if(res && res.length >0) {
                //console.log(result.body);
            }
            
            $('a').each(function(index, a) {
                var aHref = a.href;
                console.log(aHref);
                c.queue(aHref);
            });
        
        }
    }
});

c.queue(url);
//
//var Crawler = require("crawler");
//var url = require('url');
// 
//var c = new Crawler({
//    maxConnections : 10,
//    // This will be called for each crawled page 
//    callback : function (error, result, $) {
//        // $ is Cheerio by default 
//        //a lean implementation of core jQuery designed specifically for the server 
//        $('a').each(function(index, a) {
//            var toQueueUrl = $(a).attr('href');
//            c.queue(toQueueUrl);
//        });
//    }
//});
// 
//// Queue just one URL, with default callback 
//c.queue('http://joshfire.com');
// 
//// Queue a list of URLs 
//c.queue(['http://jamendo.com/','http://tedxparis.com']);
// 
//// Queue URLs with custom callbacks & parameters 
//c.queue([{
//    uri: 'http://parishackers.org/',
//    jQuery: false,
// 
//    // The global callback won't be called 
//    callback: function (error, result) {
//        console.log('Grabbed', result.body.length, 'bytes');
//    }
//}]);
// 
//// Queue using a function 
//var googleSearch = function(search) {
//  return 'http://www.google.fr/search?q=' + search;
//};
//c.queue({
//  uri: googleSearch('cheese')
//});
// 
//// Queue some HTML code directly without grabbing (mostly for tests) 
//c.queue([{
//    html: '<p>This is a <strong>test</strong></p>'
//}]);