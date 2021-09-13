#!/usr/bin/env python
# coding: utf-8

# In[1]:


import pandas as pd


# In[4]:


diagnosis = pd.read_csv("diagnosis")
events = pd.read_csv("events")


# In[5]:


events


# In[6]:


diagnosis


# In[7]:


pd.merge(events, diagnosis, how="left", left_on="EventID", right_on="EventID")


# In[ ]:




