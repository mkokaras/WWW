function func = problem4(m,x)

 for i=1:100
     f(i) = (m-(x(i)^2))*x(i);
     x(i+1)=f(i);
     fprintf('%f',x(i));
     fprintf(',');
     fprintf('%f',f(i));
     fprintf('\n');
     
 end
 

 
 x=x(1:100);
 figure(1)
 grid on;
 plot(x,f,'m*');
 xlabel('x');
 ylabel('f(x)');
end