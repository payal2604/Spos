public class priority
{
public static void main(String[] args)
{
int n = 5;
int completed = 0;
int current_time = 0;
float avgwt = 0;
float avgta = 0;
int[] pid = {1, 2, 3, 4, 5};
int[] at = {0, 0, 6, 11, 12};
int[] bt = {4, 3, 7, 4, 2};
int[] pri={2,1,5,6,3};
int[] is_completed = new int[n];
int[] ct = new int[n];
int[] ta = new int[n];
int[] wt = new int[n];
for(int i=0; i<n; i++)
is_completed[i] = 0;
while(true)
{
int c=n, minprio=999;
if(completed==n)
break;
for (int i=0; i<n; i++)
{
if ((at[i] <= current_time) && (is_completed[i] == 0) && (pri[i]<minprio))
{
minprio = pri[i];
c = i;
}
}
if (c==n)
completed++;
else
{
ct[c] = current_time + bt[c];
 current_time+= bt[c];
ta[c] = ct[c] - at[c];
wt[c] = ta[c] - bt[c];
is_completed[c] = 1;
completed++;
}
}
for (int j=0; j<n; j++)
{
avgwt += wt[j];
avgta += ta[j];
}
avgwt /= n;
avgta /= n;
System.out.println("\n\tprocess\tAT\tBT\tPri\tWT\tTAT");
for (int i=0; i<n; i++)
{
System.out.println("\t"+pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+pri[i]+"\t"+wt[i]+"\t"+ta[i]);
}
System.out.println("\nAverage waiting time is: " + avgwt);
System.out.println("Average turnaround time is: " + avgta);
}
}