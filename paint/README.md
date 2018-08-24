Paint
================

This is a plain java project, which provides logic tyo create a color batch for customer, where color requirements are specified in files. 
sample input files can be found at location /src/test/resources.
PaintManger class is main entry point, which exposes managePaint method to managePaint.
ColorBatchPool is singleton class which holds a pool for color and colorType.
Rule class provides api to manage Rule, More rule[BuisnessLogic] can be added by implementing Rule class. Right now there are 2 Rule classes exist.
Junits are provided to explain program logic.



