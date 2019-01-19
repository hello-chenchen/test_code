
    require(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout', 'ojs/ojinputtext', 'ojs/ojlabel'],
    function (oj, ko, $)
    {

      function SimpleModel(value)
      {
        this.myNumberOne = ko.observable(value[0]);
  this.myNumberTwo = ko.observable(value[1]);
  this.totalNumber = ko.computed(function() {
      var cc = [];
      cc.push(this.myNumberOne());
      cc.push(this.myNumberTwo());
      return cc;
  }, this);

      }
      ;

      $(function ()
      {
        ko.applyBindings(new SimpleModel([1,2]), document.getElementById('div1'));
    });
    
  });
