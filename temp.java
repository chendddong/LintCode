// ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]). 
// 
//                  Expression Tree <ExpressionTreeNode>:
//                  
//                                  EN(-)
//                             /            \
//                          EN(*)            EN(/)    
//                         /    \          /       \
//                      EN(2)   EN(6)    EN(+)      EN(+)
//                                      /    \      /   \
//                                  EN(23)  EN(7) EN(1) EN(2)
//                                               
//                             
//                             EN(+)
//                             /
//                                  
//                                                  
// 
// 
// 
//                          stack<TreeNode>:
//              n(2) n(+) n(1) n(/) n(7) n(+) n(23)  n(-) n(6) n(*) n(2) |
//                         x         x   x     x      √    x     x    x
// base = 0
//                                 
// node(2) = {
//              val : MAX_VALE,
//              eNode :  ExpressionTreeNode("2");
//            }
//            
// node(*) = {
//              val : 2,
//              eNode : ExpressionTreeNode("*");
//            }
//            
// node(6) = {
//              val : MAX_VALE,
//              eNode : ExpressionTreeNode("6");
//            }
// 
// node(-) = {
//              val : 1,
//              eNode : ExpressionTreeNode("-");
//            }
//            
// base = 10
// 
// node(23) = {
//              val : MAX_VALE,
//              eNode : ExpressionTreeNode("23");
//            }
// 
// node(+) = {
//              val : 11,
//              eNode : ExpressionTreeNode("+");
//            }
// 
// node(7) = {
//              val : MAX_VALE,
//              eNode : ExpressionTreeNode("7");
//            }
// 
// base = 0
// 
// node(/) = {
//              val : 2,
//              eNode : ExpressionTreeNode("/");
//            }
// 
// base = 10
// 
// node(1) = {
//              val : MAX_VALE,
//              eNode :  ExpressionTreeNode("1");
//            }
// 
// node(+) = {
//              val : 11,
//              eNode : ExpressionTreeNode("+");
//            }
// 
// node(2) = {
//              val : MAX_VALE,
//              eNode :  ExpressionTreeNode("2");
//            }
//                 
// base = 0
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
