(function($){
	var Book = Backbone.Model.extend({
		defaults:{
			coverImage:"img/test_image.png",
			title:"테스트이미지",
			date:"2015",
			keywords:"조석"
		}
	});

	var BookView = Backbone.View.extend({
		tagName:"div",
		className:"bookContainer",
		template:$("#bookTemplate").html(),
		
		render:function(){
			var tmpl = _.template(this.template);
			this.$el.html(tmpl(this.model.toJSON()));
			return this;
		}
	});

	var book = new Book({
		title:"Some title",
		date:"2015",
		keywords:"조석"
	});

	var bookView = new BookView({
		model:book
	});

	$("#books").html(bookView.render().el);
    
    
    var books = [
        {
            title:"마음의 소리1", date:"1/1", keywords:"조석"
        },
        {
            title:"마음의 소리2", date:"1/8", keywords:"조석"
        },
        {
            title:"마음의 소리3", date:"1/15", keywords:"조석"
        },
        {
            title:"마음의 소리4", date:"1/22", keywords:"조석"
        }        
    ];
    
    //Collection생성
    var Books = Backbone.Collection.extend({
        model: books
    });
    
    //CollectionView 생성
    var BooksView = Backbone.View.extend({
        el: $("#books"),
        
        initialize: function(){
            this.collection = new Books(books);
            this.render();
        },
        
        render: function(){
            var that = this;
            _.each(this.collection.models, function(item){
                that.renderBook(item);
            },this);
        },
        
        renderBook: function(item){
            bookView = new BookView({
                model: item
            });
            this.$el.append(bookView.render().el);
        }
    });
    
    var booksView = new BooksView();
})(jQuery);
