git add .
git commit -m "Update"
git push
git submodule add <repo-url-for-Password-generator> Password-generator
git submodule add <repo-url-for-Snake-Game-project> Snake-Game-project
git rm --cached -r Password-generator
git rm --cached -r Snake-Game-project

git rm -f --cached -r Password-generator
git rm -f --cached -r Snake-Game-project

# Add to .gitignore so they don't come back
echo "Password-generator/" >> .gitignore
echo "Snake-Game-project/" >> .gitignore

# Stage and commit changes
git add .
git commit -m "Clean up submodule folders and add new page file"

# Push to GitHub
git push -u origin main

# Remove them from Git tracking again
git rm -f --cached -r Password-generator
git rm -f --cached -r Snake-Game-project
Password-generator/
Snake-Game-project/
